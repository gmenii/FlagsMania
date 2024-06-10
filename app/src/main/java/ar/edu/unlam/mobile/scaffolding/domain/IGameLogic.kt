package ar.edu.unlam.mobile.scaffolding.domain

interface IGameLogic {
    fun process(allOptions: ArrayList<CountryOption>): MutableList<GameQuestion>
}
