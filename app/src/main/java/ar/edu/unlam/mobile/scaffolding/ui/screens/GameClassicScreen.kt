package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.NavHostRouterPaths
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption
import ar.edu.unlam.mobile.scaffolding.ui.components.FlagCardGame
import ar.edu.unlam.mobile.scaffolding.ui.components.GradientComponent
import ar.edu.unlam.mobile.scaffolding.ui.components.OptionButton

@Composable
fun GameClassicScreen(
    controller: NavHostController,
    viewModel: GameClassicViewModel = hiltViewModel(),
) {
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

                FlagCardGame(
                    pts = viewModel.pts,
                    actualCard = viewModel.actualCard,
                    flagURL = viewModel.currentQuestion?.correctAnswer?.flag ?: "Argentina",
                    Modifier,
                )
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            QuestionOptions(
                viewModel.currentQuestion?.options,
                viewModel.showAnswer,
                viewModel.selectedCountry,
                onClick = {
                    if (viewModel.actualCard == 10 || viewModel.counter == 0) {
                        controller.navigate(NavHostRouterPaths.GAME_RESULT.route)
                    } else {
                        viewModel.changeActualCard()
                    }
                    // viewModel.resetCounter()
                    viewModel.nextQuestion(it)
                },
            )
        }
    }
}

@Composable
fun QuestionOptions(
    optionList: List<CountryOption>?,
    readyToShowAnswer: Boolean,
    selectedCountry: String,
    onClick: (String) -> Unit = {},
) {
    optionList?.forEach {
        if (readyToShowAnswer && it.country == selectedCountry) {
            var backgroundColor = colorResource(R.color.failed)
            if (it.correct) {
                backgroundColor = colorResource(R.color.success)
            }
            OptionButton(it.country, backgroundColor, onClick = {
                onClick(it)
            })
        } else {
            OptionButton(it.country, onClick = {
                onClick(it)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameClassicScreenPreview() {
    val controller = rememberNavController()
    GameClassicScreen(controller)
}
