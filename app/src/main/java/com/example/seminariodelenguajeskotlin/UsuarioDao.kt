package com.example.seminariodelenguajeskotlin

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuarios_table")
    fun getAll(): List<Usuario>

    @Insert
    fun insertUsuario(usuario: Usuario)

    @Query("SELECT * FROM usuarios_table WHERE nombre = :nombre AND contra = :contra")
    fun getUsuario(nombre: String, contra: String): Usuario?
}

