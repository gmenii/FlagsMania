package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameClassicViewModel
    @Inject
    constructor() : ViewModel() {
        var pts by mutableStateOf(0)
        var actualCard by mutableStateOf(1)

        fun addPts(pts: Int) {
            this.pts += pts
        }

        fun changeActualCard() {
            this.actualCard++
        }
    }
