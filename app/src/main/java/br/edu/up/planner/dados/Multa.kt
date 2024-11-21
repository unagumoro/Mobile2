package br.edu.up.planner.dados

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "multa")
data class Multa(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val nome: String,
    val cpf: String,
    val numeroAutuacao: String,
    val dataInfracao: String,
    val localInfracao: String,
    val codigoInfracao: String,
    val respostas: String // Vamos salvar as respostas como uma string separada por vírgulas ou algum formato que preferir
)
