package com.example.seminariodelenguajeskotlin

import android.widget.ImageView

//lo que van a contener cada item del listado, todos por igual
data class Personaje(
    var id:Int,
    var imagen : Int,
    var personaje:String,
    var signoZ:String,
    var relacion:Int
)
