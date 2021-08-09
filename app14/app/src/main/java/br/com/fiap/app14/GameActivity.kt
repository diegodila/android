package br.com.fiap.app14

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.app14.databinding.ActivityGameBinding
import java.util.*
import kotlin.concurrent.schedule

class GameActivity : AppCompatActivity() {

    var score = 0
    var screenColor = Color.RED
    lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPrefEditor = getSharedPreferences("tapGame", Context.MODE_PRIVATE).edit()

        binding.clBackground.setOnClickListener {
            if (screenColor == Color.RED) {
                val sharedPref = getSharedPreferences("tapGame", Context.MODE_PRIVATE)
                val record = sharedPref.getInt("score", 0)

                if(score > record) {
                    sharedPrefEditor.putInt("score",score)
                    sharedPrefEditor.apply()
                }
                finish()
            }
            else{
                score++
                configureScore()
            }
        }
        configureScore()
        startGame()
    }

    private fun configureScore(){
        binding.tvTaps.text = "Taps: $score"
    }

    private fun startGame(){
        val random = (2000..5000).random().toLong()
        Timer("changeScreen",false).schedule(random){
            runOnUiThread {
                screenColor = if(screenColor == Color.RED){
                    Color.BLUE
                }else
                    Color.RED
            }
            binding.clBackground.setBackgroundColor(screenColor)
        }
        startGame()
    }
}