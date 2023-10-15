package com.example.seminariodelenguajeskotlin
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


//interfaz de conexcion con la base, manda instrucciones, primero llamas aca y de aca va automaticamente a la base
@Dao
 interface PersonajeDao {
    @Query("SELECT * FROM personaje_table")
    fun getall() : List<Personaje>
    @Insert
    fun insertPersonaje(personaje: Personaje)
}