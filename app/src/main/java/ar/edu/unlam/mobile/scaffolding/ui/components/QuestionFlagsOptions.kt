package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption

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
