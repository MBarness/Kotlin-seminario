package com.example.seminariodelenguajeskotlin

import com.example.seminariodelenguajeskotlin.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {
    @GET("people/{id}")
    fun getPost(@Path("id") id: Int): Call<Post>
}

