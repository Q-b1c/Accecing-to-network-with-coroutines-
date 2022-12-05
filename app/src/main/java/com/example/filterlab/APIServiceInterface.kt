package com.example.filterlab

import org.w3c.dom.Comment
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIServiceInterface {
    @GET("posts")
    suspend fun getPosts(): List<Data>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Data?

//    @GET("сomments")
//    suspend fun getCommentsByPostId(@Query("postId") postId: Int): List<Comment>


}