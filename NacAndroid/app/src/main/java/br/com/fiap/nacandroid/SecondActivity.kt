package br.com.fiap.nacandroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fiap.nacandroid.databinding.ActivitySecondBinding
import br.com.fiap.nacandroid.models.Covid
import br.com.fiap.nacandroid.utils.getData
import br.com.fiap.nacandroid.webservices.CovidConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {

    lateinit var binding : ActivitySecondBinding
    var access = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSearch.setOnClickListener {
            val id = binding.etId.text.toString()
            searchCovid(id)
            val sharedPref = getSharedPreferences("nacandroid", Context.MODE_PRIVATE)
            var record = sharedPref.getInt("record", 0)
            binding.tvAcess.text = "Acessos: $record"
            record++
            val sharedPrefEditor = getSharedPreferences("nacandroid", Context.MODE_PRIVATE).edit()
            sharedPrefEditor.putInt("record", record)
            sharedPrefEditor.apply()
            accessScore(record)
        }
    }

    private fun accessScore(access:Int) {
        binding.tvAcess.text = "Acessos: $access"
    }

    private fun searchCovid(id: String) {
        val callback = object : Callback<Covid> {
            override fun onResponse(call: Call<Covid>, response: Response<Covid>) {
                val covid = response.body()!!

                binding.tvUf.text = "UF: " + covid.UF
                binding.tvEstado.text = "Estado: " + covid.estado
                binding.tvCasos.text = "Casos: " + covid.casos
                binding.tvMortes.text = "Mortes: " + covid.mortes
                binding.tvDate.text = "Data: " + covid.data.getData()
            }

            override fun onFailure(call: Call<Covid>, t: Throwable) {
                Toast.makeText(this@SecondActivity,"Erro ao buscar Pokemon", Toast.LENGTH_SHORT).show()
            }

        }
        CovidConnection().covidService.getCovid(id).enqueue(callback)
    }
}