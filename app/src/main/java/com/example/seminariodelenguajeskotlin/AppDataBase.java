package com.example.seminariodelenguajeskotlin;


import androidx.room.Database;
/*
@Database(entities = [Personaje::class], version = 1)

abstract class AppDataBase:RoomDatabase() {

    abstract fun personajeDao() : PersonajeDao
    companion object{
            private var INSTANCIA : AppDataBase? = null

            fun getDataBase(contexto:Contexto):AppDataBase{
            if(INSTANCIA==NULL ){
                synchronized(this)
                INSTANCIA = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "personajes_database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            }
        }


    }
}
*/