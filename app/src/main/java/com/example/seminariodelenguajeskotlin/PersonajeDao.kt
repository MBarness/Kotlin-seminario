package com.example.seminariodelenguajeskotlin
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
 interface PersonajeDao {
    @Query("SELECT * FROM personaje_table")
    fun getall() : List<Personaje>
    @Insert
    fun insertPersonaje(personaje: Personaje)
}