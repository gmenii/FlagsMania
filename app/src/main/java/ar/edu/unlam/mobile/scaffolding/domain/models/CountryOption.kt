package ar.edu.unlam.mobile.scaffolding.domain.models

data class CountryOption(
    val country: String,
    val flag: String,
    val city: String,
    var correct: Boolean = false,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CountryOption

        return country == other.country
    }

    override fun hashCode(): Int {
        return country.hashCode()
    }
}
