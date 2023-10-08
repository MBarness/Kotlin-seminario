package com.example.seminariodelenguajeskotlin

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    var name:String,
)
