package ar.edu.unlam.mobile.scaffolding.ui.screens

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.data.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Immutable
sealed interface HelloMessageUIState {
    data class Success(val message: String) : HelloMessageUIState

    data object Loading : HelloMessageUIState

    data class Error(val message: String) : HelloMessageUIState
}

data class HomeUIState(
    val helloMessageState: HelloMessageUIState,
)

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(private val countryRepository: CountryRepository) : ViewModel() {
        // Mutable State Flow contiene un objeto de estado mutable. Simplifica la operación de
        // actualización de información y de manejo de estados de una aplicación: Cargando, Error, Éxito
        // (https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
        // _helloMessage State es el estado del componente "HelloMessage" inicializado como "Cargando"
        private val helloMessage = MutableStateFlow(HelloMessageUIState.Loading)

        // _Ui State es el estado general del view model.
        private val _uiState =
            MutableStateFlow(
                HomeUIState(helloMessage.value),
            )

        // UIState expone el estado anterior como un Flujo de Estado de solo lectura.
        // Esto impide que se pueda modificar el estado desde fuera del ViewModel.
        val uiState = _uiState.asStateFlow()

        init {
            _uiState.value = HomeUIState(HelloMessageUIState.Success("2b"))
        }

        init {
            fetchCountries()
        }

        private fun fetchCountries() {
            viewModelScope.launch {
                try {
                    countryRepository.getAllCountries().collect { countryList ->
                        Log.d("HomeViewModel", "Received countries: ${countryList.size}") // Log message
                    }
                } catch (e: Exception) {
                    Log.e("HomeViewModel", "Error fetching countries: ${e.message}") // Log error
                }
            }
        }
    }
