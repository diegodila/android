package br.com.fiap.psoceantech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.psoceantech.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvMainTitle.apply {
            alpha = 0f
            translationY = -100f
            animate()
                .setDuration(3000)
                .alphaBy(1f)
                .translationXBy(90f)
        }
        callImagesActivity()
    }
    private fun callImagesActivity() {
        Timer("callImagesActivity", false).schedule(3000){
            // Roda Aqui depois de 3000 milisegundos
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}