package ar.edu.unlam.mobile.scaffolding.domain

import ar.edu.unlam.mobile.scaffolding.domain.models.GameQuestion

class Game {
    private val questions = mutableListOf<GameQuestion>()

    fun addQuestion(gameQuestion: GameQuestion) {
        // Add the question to the game
        questions.add(gameQuestion)
    }

    fun getQuestions(): List<GameQuestion> {
        // Return the list of questions
        return questions
    }
}
