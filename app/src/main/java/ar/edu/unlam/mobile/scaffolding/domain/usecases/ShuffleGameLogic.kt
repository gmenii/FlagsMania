package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption
import ar.edu.unlam.mobile.scaffolding.domain.models.GameQuestion
import java.util.Random

private const val NUMBER_OF_ANSWERS = 4
private const val NUMBER_OF_QUESTIONS = 10

class ShuffleGameLogic : IGameLogic {
    override fun process(allOptions: ArrayList<CountryOption>): MutableList<GameQuestion> {
        val questions = mutableListOf<GameQuestion>()
        val clonedOptions = allOptions.clone() as ArrayList<CountryOption>

        repeat(NUMBER_OF_QUESTIONS) {
            // Selecciona 4 opciones aleatorias del clon de allOptions
            val selectedOptions = mutableListOf<CountryOption>()
            repeat(NUMBER_OF_ANSWERS) {
                selectRandomQuestion(clonedOptions)?.let { option ->
                    selectedOptions.add(option)
                }
            }

            // Asegúrate de tener exactamente 4 opciones
            if (selectedOptions.size == NUMBER_OF_ANSWERS) {
                // Selecciona una opción correcta aleatoriamente de las 4
                val correctOptionIndex = Random().nextInt(NUMBER_OF_ANSWERS)
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
