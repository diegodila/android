package br.com.fiap.app16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fiap.app16.databinding.ActivityMainBinding
import br.com.fiap.app16.models.Pokemon
import br.com.fiap.app16.webServices.PokemonConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSearch.setOnClickListener {
            val id = binding.etNumber.text.toString().toInt()
            searchPokemon(id)
        }

    }
    private fun searchPokemon(id: Int) {
        val callback = object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                val pokemon = response.body()!!

                binding.tvName.text = pokemon.name
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Erro ao buscar Pokemon",Toast.LENGTH_SHORT).show()
            }

        }
        PokemonConnection().pokemonService.getPokemon(id).enqueue(callback)
    }
}