package ar.edu.unlam.mobile.scaffolding.data.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// CONFIGURAR RETROFIT
// Crear el cliente Retrofit
object ApiClient {
    private const val BASE_URL = "https://restcountries.com/v3.1/"

    val retrofit: Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(BASE_URL)
            .build()
}
