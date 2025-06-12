package ar.edu.unlam.mobile.scaffolding.data.network

import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption

// CLASE DATA PARA LA RESPUESTA DE LA API
data class CountryResponse(
    @SerializedName("name")
    val name: Name,

    @SerializedName("capital")
    val capital: List<String>? = null,

    @SerializedName("region")
    val region: String? = null,

    @SerializedName("flags")
    val flags: Flags
)

data class Name(
    @SerializedName("common")
    val common: String
)

data class Flags(
    @SerializedName("png")
    val png: String
)
