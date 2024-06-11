package ar.edu.unlam.mobile.scaffolding.domain

import org.junit.Assert
import java.util.Random

private const val DEFAULT_NUMBER_OF_INCORRECT_ANSWERS = 3

class ShuffleGameLogic : IGameLogic {
    override fun process(allOptions: ArrayList<CountryOption>): MutableList<GameQuestion> {
        val questions = mutableListOf<GameQuestion>()
        allOptions.take(10).forEach {
            val cloneQuestions = allOptions.clone() as ArrayList<CountryOption>
            val incorrectOptions = arrayListOf<CountryOption>()
            val correctOption = it.copy(correct = true)
            // remove current option from the cloneQuestions
            cloneQuestions.remove(it)
            repeat(DEFAULT_NUMBER_OF_INCORRECT_ANSWERS) {
                selectRandomQuestion(cloneQuestions)?.let { option ->
                    Assert.assertNotNull(option)
                    incorrectOptions.add(option)
                }
            }
            questions.add(GameQuestion(correctOption, incorrectOptions + correctOption))
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
