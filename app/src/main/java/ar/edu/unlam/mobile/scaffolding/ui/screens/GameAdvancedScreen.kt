package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.NavHostRouterPaths
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.CardCountryGame
import ar.edu.unlam.mobile.scaffolding.ui.components.GradientComponent
import ar.edu.unlam.mobile.scaffolding.ui.components.QuestionFlagsOptions

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GameAdvancedScreen(
    controller: NavHostController,
    viewModel: GameClassicViewModel = hiltViewModel(),
) {
    fun goToResult(controller: NavHostController) {
        controller.popBackStack(NavHostRouterPaths.GAME_ADVANCED.route, true)
        controller.navigate(NavHostRouterPaths.GAME_RESULT.route)
    }

    viewModel.onCounterFinish = {
        goToResult(controller)
    }

    Column {
        Box {
            GradientComponent(250)

            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Spacer(modifier = Modifier.padding(24.dp))
                Box(
                    modifier =
                        Modifier
                            .align(Alignment.CenterHorizontally),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_white),
                        contentDescription = "Logo",
                    )
                }

                Spacer(modifier = Modifier.padding(24.dp))

                CardCountryGame(
                    pts = viewModel.pts,
                    actualCard = viewModel.actualCard,
                    viewModel = viewModel,
                    Modifier,
                )
            }
        }

        FlowRow(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            QuestionFlagsOptions(
                viewModel.currentQuestion?.options,
                viewModel.showAnswer,
                viewModel.selectedCountry,
                onClick = {
                    if (viewModel.actualCard == 10) {
                        goToResult(controller)
                    }
                    viewModel.nextFlagQuestion(it)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdvancedGameScreenPreview() {
    val controller = rememberNavController()
    GameAdvancedScreen(controller)
}
