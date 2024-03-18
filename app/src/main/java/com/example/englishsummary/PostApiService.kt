package com.example.englishsummary

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApiService {
    @GET("wp/v2/posts?_embed&&categories=&&_fields=id,excerpt,title,link,content")
    suspend fun getPosts(
        @Query("categories") kp:Int
    ): Response<List<Post>>
}