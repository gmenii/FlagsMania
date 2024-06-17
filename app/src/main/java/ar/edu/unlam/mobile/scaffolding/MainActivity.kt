package ar.edu.unlam.mobile.scaffolding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.ui.screens.GameAdvancedScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.GameClassicResultScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.GameClassicScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.HomeScreen
import ar.edu.unlam.mobile.scaffolding.ui.theme.ScaffoldingV2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldingV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    // Controller es el elemento que nos permite navegar entre pantallas. Tiene las acciones
    // para navegar como naviegate y también la información de en dónde se "encuentra" el usuario
    // a través del back stack
    val controller = rememberNavController()
    Scaffold { paddingValue ->
        // NavHost es el componente que funciona como contenedor de los otros componentes que
        // podrán ser destinos de navegación.
        NavHost(navController = controller, startDestination = NavHostRouterPaths.HOME.route) {
            // composable es el componente que se usa para definir un destino de navegación.
            // Por parámetro recibe la ruta que se utilizará para navegar a dicho destino.
            composable(NavHostRouterPaths.HOME.route) {
                // Home es el componente en sí que es el destino de navegación.
                HomeScreen(modifier = Modifier.padding(paddingValue), controller)
            }
            composable(NavHostRouterPaths.GAME_CLASSIC.route) {
                // Home es el componente en sí que es el destino de navegación.
                GameClassicScreen(controller)
            }
            composable(NavHostRouterPaths.GAME_RESULT.route) {
                // Home es el componente en sí que es el destino de navegación.
                GameClassicResultScreen(controller)
            }
            composable(NavHostRouterPaths.GAME_ADVANCED.route) {
                // Home es el componente en sí que es el destino de navegación.
                GameAdvancedScreen(controller)
            }
        }
    }
}
