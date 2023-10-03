package com.example.seminariodelenguajeskotlin

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    var name:String,
    var eye_color:String,
    var gender:String,
    var birth_year:String,
)
