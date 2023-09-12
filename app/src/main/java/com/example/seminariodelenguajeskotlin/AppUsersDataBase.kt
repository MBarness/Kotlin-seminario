package com.example.seminariodelenguajeskotlin


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class AppUsersDataBase : RoomDatabase() {

    abstract val usuarioDao: UsuarioDao

    companion object {

        private var INSTANCIA: AppUsersDataBase? = null

        fun getUserDatabase(contexto: Context): AppUsersDataBase {
            synchronized(this) {
                var instancia = INSTANCIA
                if (instancia == null) {
                    instancia = Room.databaseBuilder(
                        contexto, AppUsersDataBase::class.java, "base_app_usuarios"
                    ).allowMainThreadQueries().build()
                    INSTANCIA = instancia
                }
                return instancia
            }

        }


    }
}
