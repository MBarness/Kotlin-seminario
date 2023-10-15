package com.example.seminariodelenguajeskotlin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "personaje_table")


//lo que van a contener cada item del listado, todos por igual y las bases de la base de datos
data class Personaje(
    @ColumnInfo(name = "imagen") var imagen:Int,
    @ColumnInfo(name = "personaje") var personaje:String,
    @ColumnInfo(name = "signoZ") var signoZ:String,
    @ColumnInfo(name = "relacion") var relacion:Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
