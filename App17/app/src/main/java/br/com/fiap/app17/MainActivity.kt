package br.com.fiap.app17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import br.com.fiap.app17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLeaf.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

//        findViewById<Button>(R.id.btLeaf).setOnClickListener{
//            Toast.makeText(this@MainActivity,"Clicou na folha", Toast.LENGTH_SHORT).show()
//        }
    }
}