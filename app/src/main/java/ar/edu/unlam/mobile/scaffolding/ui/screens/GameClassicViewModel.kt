package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.runtime.State
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
        var correctAnswers by mutableStateOf(0)
        var wrongAnswers by mutableStateOf(0)
        private val _counter = mutableStateOf(10)
        val counter: State<Int> = _counter

        fun addPts(pts: Int) {
            this.pts += pts
        }

        fun changeActualCard() {
            this.actualCard++
        }

        fun addCorrectAnswer() {
            this.correctAnswers++
        }

        fun addWrongAnswer() {
            this.wrongAnswers++
        }

        fun resetCounter() {
            _counter.value = 10
        }

        fun decrementCounter() {
            if (_counter.value > 0) {
                _counter.value--
            }
        }
    }
