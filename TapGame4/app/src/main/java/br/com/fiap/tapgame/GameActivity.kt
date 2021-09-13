package br.com.fiap.tapgame

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.tapgame.databinding.ActivityGameBinding
import java.util.*
import kotlin.concurrent.schedule

class GameActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding

    var score = 0
    var screenColor = Color.RED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clBackground.setBackgroundColor(Color.RED)

        binding.clBackground.setOnClickListener {
            if (screenColor == Color.RED) {
                // PERDEU!!!

                val sharedPref = getSharedPreferences("tapgame", Context.MODE_PRIVATE)
                val record = sharedPref.getInt("record", 0)

                // Se score maior que record, salvamos o score
                if (score > record) {
                    val sharedPrefEditor = getSharedPreferences("tapgame", Context.MODE_PRIVATE).edit()
                    sharedPrefEditor.putInt("record", score)
                    sharedPrefEditor.apply()
                }

                finish()
            } else {
                // PONTO!!
                score++
                configureScore()
            }
        }

        configureScore()
        startGame()
    }

    private fun configureScore() {
        binding.tvTaps.text = "Taps: $score"
    }

    private fun startGame() {
        val random = (1500..5000).random().toLong()
        Timer("gameTimer", false).schedule(random) {
            runOnUiThread {
                screenColor = if (screenColor == Color.RED) Color.BLUE else Color.RED
                binding.clBackground.setBackgroundColor(screenColor)
            }
            startGame()
        }
    }
}