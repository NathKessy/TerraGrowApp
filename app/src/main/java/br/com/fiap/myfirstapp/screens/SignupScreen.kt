package br.com.fiap.myfirstapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.myfirstapp.R

@Composable
fun SignupScreen(navController: NavHostController) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_verde),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = { showToast(context, "Botão 1 clicado") },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp), // Aumentar a altura do botão
            colors = ButtonDefaults.buttonColors(Color(0xFF40513B))
        ) {
            Text("Mapeamento de Espaços Verdes", color = Color.White)
        }
        Button(
            onClick = { showToast(context, "Botão 2 clicado") },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp), // Aumentar a altura do botão
            colors = ButtonDefaults.buttonColors(Color(0xFF40513B))
        ) {
            Text("Planejamento e Design", color = Color.White)
        }
        Button(
            onClick = { showToast(context, "Botão 3 clicado") },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp), // Aumentar a altura do botão
            colors = ButtonDefaults.buttonColors(Color(0xFF40513B))
        ) {
            Text("Gestão de Cultivos", color = Color.White)
        }
        Button(
            onClick = {
                navController.navigate("api")
            },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp), // Aumentar a altura do botão
            colors = ButtonDefaults.buttonColors(Color(0xFF40513B))
        ) {
            Text("Monitoramento Ambiental", color = Color.White)
        }

        Button(
            onClick = { showToast(context, "Botão 5 clicado") },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp), // Aumentar a altura do botão
            colors = ButtonDefaults.buttonColors(Color(0xFF40513B))
        ) {
            Text("Comunidade e Colaboração", color = Color.White)
        }
        Button(
            onClick = { showToast(context, "Botão 6 clicado") },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp), // Aumentar a altura do botão
            colors = ButtonDefaults.buttonColors(Color(0xFF40513B))
        ) {
            Text("Educação e Conscientização", color = Color.White)
        }
        Button(
            onClick = { showToast(context, "Botão 7 clicado") },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp), // Aumentar a altura do botão
            colors = ButtonDefaults.buttonColors(Color(0xFF40513B))
        ) {
            Text("Sistemas de Irrigação Inteligentes", color = Color.White)
        }
        Button(
            onClick = { showToast(context, "Botão 8 clicado") },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp), // Aumentar a altura do botão
            colors = ButtonDefaults.buttonColors(Color(0xFF40513B))
        ) {
            Text("Recompensas e Reconhecimento", color = Color.White)
        }
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}



