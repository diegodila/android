package br.com.fiap.nacandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.nacandroid.databinding.ActivityMainBinding
import br.com.fiap.nacandroid.utils.fadeOut

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animate()

        binding.btSearch.setOnClickListener{
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        val sharedPref = getSharedPreferences("nacandroid", Context.MODE_PRIVATE)
        val record = sharedPref.getInt("record", 0)
        binding.tvAcess.text = "Acessos: $record"
    }
    private fun animate(){
            binding.ivCovid.fadeOut(8000)
    }
}