package ar.edu.unlam.mobile.scaffolding.domain

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
