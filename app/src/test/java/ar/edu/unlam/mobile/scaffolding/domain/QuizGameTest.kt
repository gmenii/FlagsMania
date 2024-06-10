package ar.edu.unlam.mobile.scaffolding.domain

import org.junit.Assert.assertEquals
import org.junit.Test

class QuizGameTest {
    @Test
    fun testRetrieveQuestions() {
        val localQuestionRepository = LocalQuestionRepository()
        val quizGame = QuizGame(localQuestionRepository)
        val questions = quizGame.getQuestions()

        assertEquals(10, questions.size)
    }

    @Test
    fun testMultipleChoiceQuestionFormat() {
        val expected =
            arrayListOf(
                CountryOption("Canada", "ca_flag.png", "Ottawa"),
                CountryOption("Spain", "es_flag.png", "Madrid"),
                CountryOption("China", "cn_flag.png", "Beijing"),
                CountryOption("USA", "us_flag.png", "Washington"),
            )

        val localQuestionRepository = LocalQuestionRepository()
        val quizGame = QuizGame(localQuestionRepository)
        val question: GameQuestion = quizGame.getQuestions()[0]

        assertEquals("USA", question.correctAnswer.country)
        assertEquals(expected, question.options)
    }

    @Test
    fun testTrackCorrectAnswersAndCalculateScore() {
        val quizGame = QuizGame(LocalQuestionRepository())
        quizGame.answerQuestion("Washington")
        quizGame.nextQuestion()
        quizGame.answerQuestion("Paris")
        quizGame.nextQuestion()
        quizGame.answerQuestion("Blue")

        assertEquals(2, quizGame.getCorrectAnswersCount())
        assertEquals(20, quizGame.calculateScore())
    }

    @Test
    fun testSummaryOfResults() {
        val localQuestionRepository = LocalQuestionRepository()
        val quizGame = QuizGame(localQuestionRepository)
        quizGame.answerQuestion("Washington")
        quizGame.nextQuestion()
        quizGame.answerQuestion("Paris")
        quizGame.nextQuestion()
        quizGame.answerQuestion("Blue")

        val summary: Summary = quizGame.getSummary()

        assertEquals(2, summary.correctAnswers)
        assertEquals(8, summary.incorrectAnswers)
        assertEquals(10, summary.totalQuestions)
        assertEquals(20, summary.totalScore)
    }

    @Test
    fun testRandomize() {
        val quizGame = QuizGame(LocalQuestionRepository(), ShuffleGameLogic())
        quizGame.randomizeQuestions()
        quizGame.getQuestions().forEach { gameQuestion ->
            println(gameQuestion.correctAnswer.country)
            gameQuestion.options.forEach { option ->
                if (option.correct) {
                    println("[*] ${option.city}")
                } else {
                    println("[ ] ${option.city}")
                }
            }
        }
    }
}
