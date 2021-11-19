package br.com.fiap.psoceantech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fiap.psoceantech.databinding.ActivityMainBinding
import br.com.fiap.psoceantech.databinding.ActivitySecondBinding
import br.com.fiap.psoceantech.models.Ocean
import br.com.fiap.psoceantech.services.DataService
import br.com.fiap.psoceantech.services.OceanService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSearch.setOnClickListener {
            val search = binding.etSearch.text.toString()
            searchData(search)

        }
    }

    private fun searchData(search: String){
        OceanService().service.searchData(
            search
        ).enqueue(object : Callback<Ocean> {
            override fun onResponse(call: Call<Ocean>, response: Response<Ocean>) {
                if(response.isSuccessful){
                    val oceanData = response.body()!!
                    binding.tvAnimais.text = oceanData.animais
                    binding.tvPhAgua.text = oceanData.phAgua
                    binding.tvResiduos.text = oceanData.residuos
                }
            }

            override fun onFailure(call: Call<Ocean>, t: Throwable) {
                Toast.makeText(this@SecondActivity, "Falha",Toast.LENGTH_SHORT)
            }

        })
    }

    private fun listData(data: List<Ocean>){

    }
}