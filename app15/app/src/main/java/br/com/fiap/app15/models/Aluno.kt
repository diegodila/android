package br.com.fiap.app15.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Aluno (
    @PrimaryKey var rm: Int,
    @ColumnInfo(name= "nome") var name: String,
    @ColumnInfo(name = "data_nascimento") var dataNascimento: String
    )