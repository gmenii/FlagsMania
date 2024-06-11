package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class OptionButtonViewModel
    @Inject
    constructor() : ViewModel() {
        var text: String = ""
        var isCorrect: Boolean = false
        var isSelected: Boolean = false
        var isDisabled: Boolean = false
    }
