package br.edu.up.planner.dados

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Multa::class], version = 1)
abstract class MultaDatabase : RoomDatabase() {

    abstract fun multaDao(): MultaDao

    companion object {
        private var INSTANCE: MultaDatabase? = null

        fun obterInstancia(context: Context): MultaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MultaDatabase::class.java,
                    "multa_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
