package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest

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
            Modifier.padding(horizontal = 16.dp, vertical = 8.dp).width(150.dp).clickable {
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
