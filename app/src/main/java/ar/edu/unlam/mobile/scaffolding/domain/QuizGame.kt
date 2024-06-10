package ar.edu.unlam.mobile.scaffolding.domain

private const val DEFAULT_POINTS_PER_QUESTION = 10

class QuizGame(optionArrayList: ArrayList<CountryOption>, val gameLogic: IGameLogic = SequentialGameLogic()) {
    private var questions = mutableListOf<GameQuestion>()
    private val answers = mutableMapOf<Int, Boolean>()
    private var questionIndex = 0

    init {
        createQuestions(optionArrayList)
    }

    private fun createQuestions(allOptions: ArrayList<CountryOption>) {
        questions = gameLogic.process(allOptions)
    }

    fun getQuestions(): List<GameQuestion> = questions

    fun getQuestion() = questions.getOrNull(questionIndex)

    fun answerQuestion(optionSelected: String): Boolean {
        var correct = false
        questions.getOrNull(questionIndex)?.let { question ->
            question.options.find { it.country == optionSelected }?.let { option ->
                correct = option.correct
            }
        }
        answers[questionIndex] = correct
        return correct
    }

    fun getCorrectAnswersCount(): Int = answers.values.filter { it }.size

    fun calculateScore(): Int = getCorrectAnswersCount() * DEFAULT_POINTS_PER_QUESTION

    fun getSummary(): Summary =
        Summary(
            getCorrectAnswersCount(),
            questions.size - getCorrectAnswersCount(),
            questions.size,
            calculateScore(),
        )

    fun nextQuestion() {
        questionIndex++
    }

    fun randomizeQuestions() {
        questions.shuffle()
        questions.forEach {
            it.options = it.options.shuffled()
        }
    }
}
