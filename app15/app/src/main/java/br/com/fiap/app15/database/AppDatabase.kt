package br.com.fiap.app15.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.fiap.app15.models.Aluno

@Database(entities = [Aluno::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun alunoDAO(): AlunoDAO
}