package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OptionButton(
    text: String,
    backgroundColor: Color = Color.White,
    labelColor: Color = Color.Black,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors =
            ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = labelColor,
            ),
        onClick = { onClick() },
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 12.dp),
    ) { Text(text = text) }
}

@Preview(showBackground = true)
@Composable
fun OptionButtonPreview() {
    OptionButton("Argentina")
}

@Preview(showBackground = true)
@Composable
fun SuccessOptionButtonPreview() {
    OptionButton("Argentina", Color.Green, Color.Black)
}

@Preview(showBackground = true)
@Composable
fun FailedOptionButtonPreview() {
    OptionButton("Argentina", Color.Red, Color.Black)
}
