package br.com.fiap.psoceantech.services

import br.com.fiap.psoceantech.models.Ocean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit
import retrofit2.http.Path


interface DataService {
    @GET("oceantech/{id}")
    fun searchData(
        @Path("id")id : String
    ) : Call<Ocean>
}

class OceanService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://616e1e33a83a850017caa7fd.mockapi.io/oceantech/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(DataService::class.java)
}