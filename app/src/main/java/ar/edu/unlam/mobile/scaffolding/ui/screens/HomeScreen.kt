package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.NavHostRouterPaths
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.MenuOptionButton

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    controller: NavHostController,
) {
    Scaffold(topBar = {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier =
                modifier
                    .fillMaxWidth()
                    .padding(vertical = 64.dp),
            alignment = Alignment.Center,
        )
    }) { paddingValue ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MenuOptionButton(
                onClick = {
                    controller.navigate(
                        NavHostRouterPaths.GAME_CLASSIC
                            .route,
                    )
                },
                title = "MODO CLÁSICO",
                description =
                    "¿Serás capaz de adivinar todas " +
                        "las banderas antes de que se termine el tiempo?",
            )
            MenuOptionButton(
                onClick = {
                    controller.navigate(
                        NavHostRouterPaths.GAME_ADVANCED
                            .route,
                    )
                },
                title = "MODO AVANZADO",
                description =
                    "¿1 bandera? Na, mejor 4. ¿Podrás " +
                        "adivinarlas todas antes de que se termine el tiempo?",
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val controller = rememberNavController()
    HomeScreen(controller = controller)
}
