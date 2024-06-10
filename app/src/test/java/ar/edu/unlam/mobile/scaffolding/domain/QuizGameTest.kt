package ar.edu.unlam.mobile.scaffolding.domain

import org.junit.Assert.assertEquals
import org.junit.Test

class QuizGameTest {
    @Test
    fun testRetrieveQuestions() {
        val localQuestionRepository = LocalQuestionRepository()
        val quizGame = QuizGame(localQuestionRepository)
        val questions = quizGame.getQuestions()

        assertEquals(3, questions.size)
    }

    @Test
    fun testMultipleChoiceQuestionFormat() {
        val expected =
            arrayListOf(
                CountryOption("USA", "us_flag.png", "Washington"),
                CountryOption("France", "fr_flag.png", "Paris"),
                CountryOption("Germany", "de_flag.png", "Berlin"),
                CountryOption("Japan", "jp_flag.png", "Tokyo"),
            )

        val localQuestionRepository = LocalQuestionRepository()
        val quizGame = QuizGame(localQuestionRepository)
        val question: GameQuestion = quizGame.getQuestions()[0]

        assertEquals("USA", question.correctAnswer.country)
        assertEquals(expected, question.options)
    }

    @Test
    fun testTrackCorrectAnswersAndCalculateScore() {
        val localQuestionRepository = LocalQuestionRepository()
        val quizGame = QuizGame(localQuestionRepository)
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
        assertEquals(1, summary.incorrectAnswers)
        assertEquals(3, summary.totalQuestions)
        assertEquals(20, summary.totalScore)
    }

    @Test
    fun testRandomize() {
        val localQuestionRepository = LocalQuestionRepository()
        val quizGame = QuizGame(localQuestionRepository)
        quizGame.randomizeQuestions()
        quizGame.getQuestions().forEach { gameQuestion ->
            println("gameQuestion:${gameQuestion.correctAnswer.country}")
            gameQuestion.options.forEach { option ->
                println("option:$option")
            }
        }
    }
}
