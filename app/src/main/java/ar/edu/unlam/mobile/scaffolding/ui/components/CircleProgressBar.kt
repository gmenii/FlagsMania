package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircleProgress(
    progress: Float,
    label: String,
) {
    val strokeWidth = 20.dp
    val diameter = 200.dp
    val radius = diameter / 2
    val progressColor = MaterialTheme.colorScheme.primary

    val progressAngle by remember(progress) { mutableStateOf(360f * progress) }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color.Black,
                style = Stroke(width = strokeWidth.toPx()),
                center = Offset(size.width / 2, size.height / 2),
                radius = radius.toPx(),
            )

            drawArc(
                color = progressColor,
                startAngle = -90f,
                sweepAngle = progressAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth.toPx()),
            )
        }

        Label(label = label)
    }
}

@Composable
fun Label(label: String) {
    Text(
        text = label,
        color = Color.Black,
        fontSize = 24.sp,
        modifier = Modifier.padding(top = 8.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun CircleProgressPreview() {
    CircleProgress(progress = 0.7f, label = "11s")
}

private fun DrawScope.drawCircularIndicator(
    startAngle: Float,
    sweep: Float,
    gradientStart: Color,
    gradientEnd: Color,
    stroke: Stroke,
) {
    // To draw this circle we need a rect with edges that line up with the midpoint of the stroke.
    // To do this we need to remove half the stroke width from the total diameter for both sides.
    val diameterOffset = stroke.width / 2
    val arcDimen = size.width - 2 * diameterOffset
    drawArc(
        // 👇 using Brush.linearGradient() to draw a gradient 👇
        brush = Brush.linearGradient(listOf(gradientStart, gradientEnd)),
        startAngle = startAngle,
        sweepAngle = sweep,
        useCenter = false,
        topLeft = Offset(diameterOffset, diameterOffset),
        size = Size(arcDimen, arcDimen),
        style = stroke,
    )
}

@Composable
fun CircularIndicatorPreview() {
    Canvas(modifier = Modifier.size(200.dp)) {
        drawCircularIndicator(
            startAngle = 0f,
            sweep = 270f,
            gradientStart = Color.Red,
            gradientEnd = Color.Blue,
            stroke = Stroke(width = 30f),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCircularIndicatorPreview() {
    CircularIndicatorPreview()
}
