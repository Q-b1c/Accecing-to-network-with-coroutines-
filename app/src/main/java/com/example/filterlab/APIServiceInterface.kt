package com.example.filterlab

import retrofit2.http.GET
import retrofit2.http.Path

interface APIServiceInterface {
    @GET("todos")
    suspend fun getTodos(): List<Data>

    @GET("todos/{id}")
    suspend fun getTodosById(@Path("id") id: Int): Data?
}