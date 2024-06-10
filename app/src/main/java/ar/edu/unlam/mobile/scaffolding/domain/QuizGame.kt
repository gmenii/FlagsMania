package ar.edu.unlam.mobile.scaffolding.domain

private const val DEFAULT_POINTS_PER_QUESTION = 10

class QuizGame(questionRepository: IQuestionRepository) {
    private val questions = mutableListOf<GameQuestion>()
    private val answers = mutableMapOf<Int, Boolean>()
    private var questionIndex = 0

    init {
        createQuestions(questionRepository.getAllOptions())
    }

    private fun createQuestions(allOptions: ArrayList<CountryOption>) {
        allOptions[0].correct = true
        allOptions[1].correct = true
        allOptions[2].correct = true
        questions.add(GameQuestion(allOptions[0], allOptions.subList(0, 4)))
        questions.add(GameQuestion(allOptions[1], allOptions.subList(0, 4)))
        questions.add(GameQuestion(allOptions[2], allOptions.subList(0, 4)))
    }

    fun getQuestions(): List<GameQuestion> = questions

    fun answerQuestion(optionSelected: String) {
        var correct = false
        questions.getOrNull(questionIndex)?.let { question ->
            question.options.find { it.city == optionSelected }?.let { option ->
                correct = option.correct
            }
        }
        answers[questionIndex] = correct
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
