package ar.edu.unlam.mobile.scaffolding.data.network

// CLASE DATA PARA LA RESPUESTA DE LA API
data class CountryResponse(
    val name: String,
    val capital: List<String>?,
    val region: String,
    val population: Int,
    val flag: String,
)

data class Name(
    val common: String,
    val official: String,
)

data class Flags(
    val svg: String,
    val png: String,
)
