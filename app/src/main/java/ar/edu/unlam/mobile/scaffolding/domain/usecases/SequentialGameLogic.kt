package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption
import ar.edu.unlam.mobile.scaffolding.domain.models.GameQuestion

class SequentialGameLogic : IGameLogic {
    override fun process(allOptions: ArrayList<CountryOption>): MutableList<GameQuestion> {
        val questions = mutableListOf<GameQuestion>()
        allOptions.forEach {
            val correctOption = it.copy(correct = true)
            questions.add(GameQuestion(correctOption, allOptions.subList(7, 10) + correctOption))
        }
        return questions
    }
}
