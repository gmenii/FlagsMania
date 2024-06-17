package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameClassicResultViewModel
    @Inject
    constructor(private val gameResultUseCase: GameResultUseCase) : ViewModel() {
        private val _gameResults = MutableStateFlow<List<GameResult>>(emptyList())
        val gameResults: StateFlow<List<GameResult>> = _gameResults

        val firstGameResult: GameResult?
            get() = _gameResults.value.firstOrNull()

        init {
            fetchGameResults()
        }

        private fun fetchGameResults() {
            viewModelScope.launch {
                gameResultUseCase.getGameResults().collect { results ->
                    _gameResults.value = results
                    // Log para verificar la actualización de datos
                }
            }
        }
    }
