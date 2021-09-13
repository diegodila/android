package br.com.fiap.app16.webServices

import br.com.fiap.app16.models.Pokemon
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/{id}")
    fun getPokemon(@Path("id")id:Int) : Call<Pokemon>
}

class PokemonConnection {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val pokemonService = retrofit.create(PokemonService::class.java)
}