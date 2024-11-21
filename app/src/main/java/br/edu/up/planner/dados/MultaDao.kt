package br.edu.up.planner.dados

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MultaDao {

    // Inserir uma nova multa
    @Insert
    suspend fun inserirMulta(multa: Multa)
}
