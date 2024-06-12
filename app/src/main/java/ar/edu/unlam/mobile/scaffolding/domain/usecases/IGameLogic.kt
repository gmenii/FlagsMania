package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption
import ar.edu.unlam.mobile.scaffolding.domain.models.GameQuestion

interface IGameLogic {
    fun process(allOptions: ArrayList<CountryOption>): MutableList<GameQuestion>
}
