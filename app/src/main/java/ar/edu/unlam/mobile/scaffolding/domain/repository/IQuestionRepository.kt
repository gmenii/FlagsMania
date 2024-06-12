package ar.edu.unlam.mobile.scaffolding.domain.repository

import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption

interface IQuestionRepository {
    fun getAllOptions(): ArrayList<CountryOption>
}
