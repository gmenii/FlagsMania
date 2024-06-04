package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameClassicViewModel
    @Inject
    constructor() : ViewModel() {
        // create a variable potins that persist across lifecycle
//        val points by remember { mutableStateOf(0) }
        var points = 0

        init {
            println("==test==")
        }
    }
