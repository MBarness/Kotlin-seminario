package com.example.seminariodelenguajeskotlin;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

//@dao es para avisarle a room(la base de datos) que esta va a ser la intermediaria entre
//la data clas y la base, osea la q tiene las funciones
/*
@Dao
public interface PersonajeDao {
    @Query("SELECT * FROM personaje_table")
    fun getAll() : List<Personaje>
    @Insert
    fun insertPersonaje(personaje: Personaje)
}
*/