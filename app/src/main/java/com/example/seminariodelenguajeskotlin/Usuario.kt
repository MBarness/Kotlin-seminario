package com.example.seminariodelenguajeskotlin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "usuarios_table")
data class Usuario(
    @ColumnInfo(name = "nombre") var nombre:String,
    @ColumnInfo(name = "contra") var contra:String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
