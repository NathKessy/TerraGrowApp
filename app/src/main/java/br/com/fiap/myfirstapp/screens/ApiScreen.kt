import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

data class WeatherInfo(
    val temperature: String?,
    val description: String?,
    val humidity: String?,
    val windSpeed: String?
)

@Composable
fun ApiScreen() {
    var city by remember { mutableStateOf("") }
    var weatherInfo by remember { mutableStateOf<WeatherInfo?>(null) }
    val context = LocalContext.current

    LaunchedEffect(city) {
        if (city.isNotEmpty()) {
            val info = fetchWeather(city, context)
            weatherInfo = info
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF7AD1F8),
                        Color(0xFFC3AAF0)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset.Infinite
                )
            )
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("Pesquise uma cidade") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                }),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            weatherInfo?.let {
                Text(
                    text = it.temperature ?: "",
                    fontSize = 24.sp
                )

                Text(
                    text = it.description ?: "",
                    fontSize = 18.sp
                )

                Text(
                    text = it.humidity ?: "",
                    fontSize = 18.sp
                )

                Text(
                    text = it.windSpeed ?: "",
                    fontSize = 18.sp
                )
            }
        }
    }
}

suspend fun fetchWeather(city: String, context: android.content.Context): WeatherInfo? {
    val apiKey = "4f4879f7a1b95695cbbbc8959327e984"
    val apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey&units=metric"

    return withContext(Dispatchers.IO) {
        try {
            val result = URL(apiUrl).readText()
            val jsonObject = org.json.JSONObject(result)
            val main = jsonObject.getJSONObject("main")
            val temp = main.getString("temp")
            val weatherArray = jsonObject.getJSONArray("weather")
            val weatherObject = weatherArray.getJSONObject(0)
            val description = weatherObject.getString("description")
            val humidity = main.getString("humidity")
            val wind = jsonObject.getJSONObject("wind")
            val windSpeed = wind.getString("speed")
            WeatherInfo("Temperatura na $city: $temp °C", description, "Umidade: $humidity%", "Velocidade do vento: $windSpeed m/s")
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

