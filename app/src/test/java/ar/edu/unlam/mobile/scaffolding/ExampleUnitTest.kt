package ar.edu.unlam.mobile.scaffolding

import ar.edu.unlam.mobile.scaffolding.domain.Game
import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption
import ar.edu.unlam.mobile.scaffolding.domain.models.GameQuestion
import ar.edu.unlam.mobile.scaffolding.domain.services.QuizHelper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testSelectRandomQuestion() {
        val quizHelper = QuizHelper()
        val questionsList =
            arrayListOf(
                "Question 1",
                "Question 2",
                "Question 3",
                "Question 4",
                "Question 5",
                "Question 6",
                "Question 7",
                "Question 8",
                "Question 9",
                "Question 10",
            )
        val selectedQuestions = mutableSetOf<String>()

        // Select 10 random questions from the list
        repeat(10) {
            val selectedQuestion = quizHelper.selectRandomStringQuestion(questionsList)
            assertNotNull(selectedQuestion)
            assertFalse(selectedQuestions.contains(selectedQuestion))
            selectedQuestions.add(selectedQuestion!!)
        }

        // Ensure that all questions were selected without repetition
        assertEquals(10, selectedQuestions.size)
    }

    @Test
    fun testSelectRandomCountryQuestion() {
        val quizHelper = QuizHelper()
        val questionsList = getCountryQuestion()
        val selectedQuestions = mutableSetOf<CountryOption>()

        // Select 10 random questions from the list
        repeat(10) {
            val selectedQuestion = quizHelper.selectRandomQuestion(questionsList)
            assertNotNull(selectedQuestion)
            assertFalse(selectedQuestions.contains(selectedQuestion))
            selectedQuestions.add(selectedQuestion!!)
        }

        // Ensure that all questions were selected without repetition
        assertEquals(10, selectedQuestions.size)
    }

    @Test
    fun testSelectRandomCountryQuestionAndOptions() {
        val quizHelper = QuizHelper()
        val questionsList = getCountryQuestion()
        val game = Game()

        // Select the correct answer
        val correctAnswer = quizHelper.selectRandomQuestion(questionsList)
        if (correctAnswer != null) {
            correctAnswer.correct = true

            // Select 3 incorrect options
            val incorrectOptions = arrayListOf<CountryOption>()
            val defaultIncorrectOptionsNumber = 3
            repeat(defaultIncorrectOptionsNumber) {
                quizHelper.selectRandomQuestion(questionsList)?.let { option ->
                    assertNotNull(option)
                    incorrectOptions.add(option)
                }
            }

            // Create quiz question with correct and incorrect options
            val options = (arrayListOf(correctAnswer) + incorrectOptions).shuffled()
            game.addQuestion(GameQuestion(correctAnswer, options))
        }

        game.getQuestions().forEach { gameQuestion ->
            printQuestion(gameQuestion)
        }
    }

    private fun printQuestion(game: GameQuestion) {
        val stringBuffer = StringBuffer()
        game.options.forEachIndexed { index, option ->
            if (option.correct) {
                stringBuffer.append("${"ABCD"[index]}. ${option.city} **\n")
            } else {
                stringBuffer.append("${"ABCD"[index]}. ${option.city}\n")
            }
        }
        println("What is the capital of ${game.correctAnswer.country}")
        println(stringBuffer.toString())
    }

    private fun getCountryQuestion() =
        arrayListOf(
            CountryOption("USA", "us_flag.png", "Washington"),
            CountryOption("France", "fr_flag.png", "Paris"),
            CountryOption("Germany", "de_flag.png", "Berlin"),
            CountryOption("Japan", "jp_flag.png", "Tokyo"),
            CountryOption("Australia", "au_flag.png", "Sydney"),
            CountryOption("Brazil", "br_flag.png", "Brasilia"),
            CountryOption("Italy", "it_flag.png", "Rome"),
            CountryOption("Canada", "ca_flag.png", "Ottawa"),
            CountryOption("Spain", "es_flag.png", "Madrid"),
            CountryOption("China", "cn_flag.png", "Beijing"),
        )
}
