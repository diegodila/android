package br.com.fiap.nacandroid.webservices

import br.com.fiap.nacandroid.models.Covid
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CovidService {
    @GET("brazil/uf/{id}")
    fun getCovid(@Path("id")id:String) : Call<Covid>
}

class CovidConnection {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://covid19-brazil-api.now.sh/api/report/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val covidService = retrofit.create(CovidService::class.java)
}