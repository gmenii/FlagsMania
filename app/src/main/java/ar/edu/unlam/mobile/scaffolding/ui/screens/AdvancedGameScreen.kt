package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.NavHostRouterPaths
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption
import ar.edu.unlam.mobile.scaffolding.ui.components.CounterHolder
import ar.edu.unlam.mobile.scaffolding.ui.components.GradientComponent
import ar.edu.unlam.mobile.scaffolding.ui.theme.AppFont
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AdvancedGameScreen(
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

                CardCountryGame(
                    pts = viewModel.pts,
                    actualCard = viewModel.actualCard,
                    viewModel = viewModel,
                    Modifier,
                )
            }
        }

        Column(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
        ) {
            QuestionFlagsOptions(
                viewModel.currentQuestion?.options,
                viewModel.showAnswer,
                viewModel.selectedCountry,
                onClick = {
                    if (viewModel.actualCard == 10 || viewModel.counter == 0) {
                        controller.navigate(NavHostRouterPaths.GAME_RESULT.route)
                    } else {
                        viewModel.changeActualCard()
                    }
                    viewModel.resetCounter()
                    viewModel.nextFlagQuestion(it)
                },
            )
        }
    }
}

@Composable
fun QuestionFlagsOptions(
    optionList: List<CountryOption>?,
    readyToShowAnswer: Boolean,
    selectedCountry: String,
    onClick: (String) -> Unit = {},
) {
    optionList?.forEach {
        if (readyToShowAnswer && it.flag == selectedCountry) {
            var backgroundColor = colorResource(R.color.failed)
            if (it.correct) {
                backgroundColor = colorResource(R.color.success)
            }
            OptionFlag(it.flag, backgroundColor, onClick = {
                onClick(it)
            })
        } else {
            OptionFlag(it.flag, onClick = {
                onClick(it)
            })
        }
    }
}

@Composable
fun CardCountryGame(
    pts: Int = 0,
    actualCard: Int = 0,
    viewModel: GameClassicViewModel,
    modifier: Modifier,
) {
    Box {
        CounterHolder(modifier, viewModel)
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFECECEC)),
            modifier =
                modifier
                    .padding(horizontal = 36.dp, vertical = 10.dp)
                    .fillMaxWidth(),
        ) {
            Row(
                modifier =
                    modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "$actualCard/10",
                    color = Color(0xFFC4007A),
                    fontFamily = AppFont.Quicksand,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
            }
            Column(
                modifier =
                    modifier
                        .padding(16.dp)
                        .wrapContentHeight().fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    viewModel.currentQuestion?.correctAnswer?.country.toString(),
                    color = Color(0xFFC4007A),
                    fontFamily = AppFont.Quicksand,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
                Spacer(modifier = modifier.height(16.dp))

                // Points text
                Text(
                    text = "$pts pts.",
                    color = Color(0xFFC4007A),
                    fontSize = 16.sp,
                    fontFamily = AppFont.Quicksand,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.align(Alignment.CenterHorizontally),
                )
            }
        }
    }
}

@Composable
fun OptionFlag(
    flagUrl: String,
    backgroundColor: Color = Color(0xFFECECEC),
    labelColor: Color = Color.Black,
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Card(
        modifier =
            Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth().clickable {
                onClick(flagUrl)
            },
        colors =
            CardDefaults.cardColors(
                containerColor = backgroundColor,
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
    ) {
        AsyncImage(
            model =
                ImageRequest.Builder(LocalContext.current).data(flagUrl)
                    .decoderFactory(SvgDecoder.Factory()).build(),
            contentDescription = "Flag option",
            modifier =
                modifier
                    .padding(16.dp)
                    .height(60.dp)
                    .align(Alignment.CenterHorizontally),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AdvancedGameScreenPreview() {
    val controller = rememberNavController()
    AdvancedGameScreen(controller)
}
