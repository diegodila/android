package br.com.fiap.app15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import br.com.fiap.app15.database.AppDatabase
import br.com.fiap.app15.databinding.ActivityMainBinding
import br.com.fiap.app15.models.Aluno

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val date = binding.etBirthDate.text.toString()

            insertAluno(
                Aluno(
                getALunos().size+1,
                    name,
                    date
            ))
            showALunos()
        }
        showALunos()

    }
    private fun getALunos():List<Aluno> {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "base-alunos"
        ).allowMainThreadQueries().build()

        return db.alunoDAO().getAll()
    }
    private fun insertAluno(aluno: Aluno) {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "base-alunos"
        ).allowMainThreadQueries().build()

        db.alunoDAO().insertAll(aluno)
    }

    private  fun showALunos() {

        val alunos = getALunos()

        var alunosStr = ""
        alunos.forEach{
            aluno ->
            alunosStr += "\n${aluno.rm} | ${aluno.name} | ${aluno.dataNascimento}"
        }
        binding.tvResult.text = alunosStr
    }
}