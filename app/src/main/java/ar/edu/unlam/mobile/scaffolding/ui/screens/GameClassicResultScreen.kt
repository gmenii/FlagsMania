package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.CustomButton

@Composable
fun GameClassicResultScreen() {
    Column(
        modifier =
            Modifier
                .fillMaxSize(), // Extiende el Column a toda la pantalla
    ) {
        // Logo centrado en la parte superior
        Box(
            modifier =
                Modifier
                    .fillMaxWidth() // Ocupa el ancho máximo disponible
                    .height(100.dp) // Define la altura del logo (ajusta según tu logo)
                    .align(Alignment.CenterHorizontally) // Centra en la parte superior
                    .padding(top = 50.dp, bottom = 30.dp) // Espacio superior e inferior
                    .padding(start = 150.dp, end = 150.dp),
            // Espacio alrededor del logo
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_white),
                contentDescription = "Logo",
                modifier =
                    Modifier
                        .size(width = 250.dp, height = 51.73.dp),
            )
        }
        Column(
            modifier =
                Modifier
                    .fillMaxSize() // Extiende el Column a toda la pantalla
                    .background(Color.White) // Fondo blanco en el Column
                    .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier =
                    Modifier
                        .size(200.dp)
                        .background(Color.White)
                        .padding(16.dp),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar_image),
                        contentDescription = "Avatar",
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Banderas correctas    1/10")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Banderas incorrectas  9/10")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Puntos Totales        100pts")
                }
            }

            Spacer(modifier = Modifier.height(150.dp))

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CustomButton(text = "Volver a jugar")
                Spacer(modifier = Modifier.height(16.dp))
                CustomButton(text = "Menu principal")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameClassicResultScreenPreview() {
    GameClassicResultScreen()
}
