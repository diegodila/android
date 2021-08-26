package br.com.fiap.app15.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.app15.models.Aluno

@Dao
interface AlunoDAO {

    @Query("SELECT * FROM aluno")
    fun getAll() : List<Aluno>

    @Query("SELECT * FROM aluno WHERE rm = :rm")
    fun getByRm(rm:Int): Aluno

    @Insert
    fun insertAll(vararg  alunos: Aluno)

    @Delete
    fun delete(user: Aluno)

}