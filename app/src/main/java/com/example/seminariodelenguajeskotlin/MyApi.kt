package com.example.seminariodelenguajeskotlin

import com.example.seminariodelenguajeskotlin.Post
import retrofit2.Call
import retrofit2.http.GET


interface MyApi {
    @GET("/")
    fun getPost() : Call<List<Post>>

}