package ar.edu.unlam.mobile.scaffolding

import ar.edu.unlam.mobile.scaffolding.domain.CountryQuestion
import ar.edu.unlam.mobile.scaffolding.domain.QuizHelper
import org.junit.Assert.*
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
        val questionsList = arrayListOf(
            "Question 1", "Question 2", "Question 3", "Question 4", "Question 5",
            "Question 6", "Question 7", "Question 8", "Question 9", "Question 10"
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
        val questionsList = arrayListOf(
            CountryQuestion("USA", "us_flag.png", "Washington"),
            CountryQuestion("France", "fr_flag.png", "Paris"),
            CountryQuestion("Germany", "de_flag.png", "Berlin"),
            CountryQuestion("Japan", "jp_flag.png", "Tokyo"),
            CountryQuestion("Australia", "au_flag.png", "Sydney"),
            CountryQuestion("Brazil", "br_flag.png", "Brasilia"),
            CountryQuestion("Italy", "it_flag.png", "Rome"),
            CountryQuestion("Canada", "ca_flag.png", "Ottawa"),
            CountryQuestion("Spain", "es_flag.png", "Madrid"),
            CountryQuestion("China", "cn_flag.png", "Beijing")
        )
        val selectedQuestions = mutableSetOf<CountryQuestion>()

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
        val questionsList = arrayListOf(
            CountryQuestion("USA", "us_flag.png", "Washington"),
            CountryQuestion("France", "fr_flag.png", "Paris"),
            CountryQuestion("Germany", "de_flag.png", "Berlin"),
            CountryQuestion("Japan", "jp_flag.png", "Tokyo"),
            CountryQuestion("Australia", "au_flag.png", "Sydney"),
            CountryQuestion("Brazil", "br_flag.png", "Brasilia"),
            CountryQuestion("Italy", "it_flag.png", "Rome"),
            CountryQuestion("Canada", "ca_flag.png", "Ottawa"),
            CountryQuestion("Spain", "es_flag.png", "Madrid"),
            CountryQuestion("China", "cn_flag.png", "Beijing")
        )

        // Select the correct answer
        val correctAnswer = quizHelper.selectRandomQuestion(questionsList)
        assertNotNull(correctAnswer)

        // Select 3 incorrect options
        val incorrectOptions = arrayListOf<CountryQuestion>()
        repeat(3) {
            val incorrectOption = quizHelper.selectRandomQuestion(questionsList)
            assertNotNull(incorrectOption)
            incorrectOptions.add(incorrectOption!!)
        }

        // Create quiz question with correct and incorrect options
        val quizQuestion = "What is the capital of ${correctAnswer!!.country}?"
        var options: List<CountryQuestion> = (arrayListOf(correctAnswer) + incorrectOptions).shuffled()
        println("Quiz Question: $quizQuestion")
        options.forEachIndexed { index, option ->
            if (option.city == correctAnswer.city) {
                println("${"ABCD"[index]}. ${option.city} **")
            } else {
                println("${"ABCD"[index]}. ${option.city}")
            }

        }
    }
}
