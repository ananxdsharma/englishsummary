package com.example.englishsummary

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApiService {
    @GET("wp/v2/posts?_embed&fields=id,excerpt,title,link,content")
    suspend fun getPosts(
        @Query("categories") kp: Int
    ): Response<List<Post>>

    @GET("wp/v2/posts?_embed&categories=id,excerpt,title,link,content&page=1&per_page=3")
    suspend fun getArchivePosts(
        @Query("categories") kp: Int,
        @Query("per_page") postcount: Int
    ): Response<List<Post>>

//
//    @GET("")
//    suspend fun get getIndianBoardArchivePosts(
//    @Query("categories") kp: Int,
//    @Query("per_page") postcount: Int
//    ):Response<List<Post>>
}
//https://englishsummary.com/wp-json/wp/v2/course?course_cat=1493