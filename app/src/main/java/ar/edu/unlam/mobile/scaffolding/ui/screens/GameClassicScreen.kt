package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.OptionButton

@Composable
fun GameClassicScreen() {
    Column {
        Box(
            modifier =
                Modifier
                    .background(Color.Black)
                    .align(Alignment.CenterHorizontally),
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_white),
                contentDescription = "Logo",
            )
        }

        Column(modifier = Modifier.padding(16.dp)) {
            QuestionOptions()
        }
    }
}

@Composable
fun QuestionOptions() {
    // simple button with a text inside "Argentina"
    OptionButton("Argentina", colorResource(R.color.failed), Color.White)
    OptionButton("Francia", colorResource(R.color.success), Color.White)
    OptionButton("España")
    OptionButton("Italia")
}

@Preview(showBackground = true)
@Composable
fun GameClassicScreenPreview() {
    GameClassicScreen()
}
