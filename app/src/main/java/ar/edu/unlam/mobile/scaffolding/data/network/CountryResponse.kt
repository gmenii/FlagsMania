package ar.edu.unlam.mobile.scaffolding.data.network

import ar.edu.unlam.mobile.scaffolding.domain.CountryOption

// CLASE DATA PARA LA RESPUESTA DE LA API
data class CountryResponse(
    val name: String,
    val capital: List<String>?,
    val region: String,
    val population: Int,
    val flag: String,
) {
    fun toCountryOption(): CountryOption {
        return CountryOption(
            country = name,
            flag = flag,
            city = capital?.getOrNull(0) ?: "",
        )
    }
}
