package ar.edu.unlam.mobile.scaffolding.data.network
import retrofit2.http.GET

// DEFINIR LA INTERFACE DE LA API
interface CountryApiService {
    @GET("v3.1/all")
    suspend fun getAllCountries(): List<CountryResponse>
}
