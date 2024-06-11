package ar.edu.unlam.mobile.scaffolding.domain

interface IQuestionRepository {
    fun getAllOptions(): ArrayList<CountryOption>
}
