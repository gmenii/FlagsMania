package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameClassicViewModel
    @Inject
    constructor() : ViewModel() {
        var pts = 0
        var actualCard = 1

        init {
            var pts = 0
            var actualCard = 1
        }

        fun addPts(pts: Int) {
            this.pts += pts
        }

        fun changeActualCard() {
            this.actualCard++
        }
    }
