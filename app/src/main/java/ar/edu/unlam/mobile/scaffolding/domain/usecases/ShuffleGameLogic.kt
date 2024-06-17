package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption
import ar.edu.unlam.mobile.scaffolding.domain.models.GameQuestion
import java.util.Random

private const val DEFAULT_NUMBER_OF_INCORRECT_ANSWERS = 3

class ShuffleGameLogic : IGameLogic {
    override fun process(allOptions: ArrayList<CountryOption>): MutableList<GameQuestion> {
        val questions = mutableListOf<GameQuestion>()
        val clonedOptions = allOptions.clone() as ArrayList<CountryOption>

        repeat(10) {
            // Selecciona 4 opciones aleatorias del clon de allOptions
            val selectedOptions = mutableListOf<CountryOption>()
            repeat(4) {
                selectRandomQuestion(clonedOptions)?.let { option ->
                    selectedOptions.add(option)
                }
            }

            // Asegúrate de tener exactamente 4 opciones
            if (selectedOptions.size == 4) {
                // Selecciona una opción correcta aleatoriamente de las 4
                val correctOptionIndex = Random().nextInt(4)
                val correctOption = selectedOptions[correctOptionIndex].copy(correct = true)

                // Marca las demás opciones como incorrectas
                val incorrectOptions = selectedOptions.filterIndexed { index, _ -> index != correctOptionIndex }

                // Agrega la pregunta con la opción correcta y las incorrectas a la lista de preguntas
                questions.add(GameQuestion(correctOption, incorrectOptions + correctOption))
            }
        }
        return questions
    }

    private fun selectRandomQuestion(questions: ArrayList<CountryOption>): CountryOption? {
        if (questions.isEmpty()) {
            return null
        }
        val random = Random()
        val index = random.nextInt(questions.size)
        return questions.removeAt(index)
    }
}
