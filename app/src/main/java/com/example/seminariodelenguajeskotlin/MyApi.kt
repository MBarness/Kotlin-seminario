package com.example.seminariodelenguajeskotlin

import com.example.seminariodelenguajeskotlin.Post
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("people/{id}")
    fun getPost(id: Int) : Call<Post> // Cambiamos el tipo de retorno a Call<Post>
}

