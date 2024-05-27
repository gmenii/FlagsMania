package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import ar.edu.unlam.mobile.scaffolding.R

@Composable
fun CustomButton(text: String) {
    Button(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(ButtonDefaults.MinHeight)
                .background(
                    brush =
                        Brush.horizontalGradient(
                            colors =
                                listOf(
                                    colorResource(R.color.orange),
                                    colorResource(R.color.magenta),
                                ),
                        ),
                    shape = ButtonDefaults.shape,
                ),
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            ),
        onClick = {},
        // elevation = ButtonDefaults.buttonElevation(defaultElevation = 12.dp)
    ) { Text(text = text) }
}
