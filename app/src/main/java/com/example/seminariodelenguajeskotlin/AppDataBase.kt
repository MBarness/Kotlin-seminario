package com.example.seminariodelenguajeskotlin


import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase



//base de datos
@Database(entities = [Personaje::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun personajeDao(): PersonajeDao

    companion object {
        private var INSTANCIA: AppDataBase? = null

        fun getDataBase(contexto: Context): AppDataBase {
            if (INSTANCIA == null) {
                synchronized(this) {
                    INSTANCIA = Room.databaseBuilder(
                        contexto, AppDataBase::class.java, "personajes_database"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCIA!!
        }
    }
}
