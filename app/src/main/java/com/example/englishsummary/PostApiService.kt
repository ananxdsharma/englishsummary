package com.example.englishsummary

import retrofit2.Response
import retrofit2.http.GET

interface PostApiService {
    @GET("wp/v2/posts?_embed&&categories=1369&&_fields=id,excerpt,title,link,content")
    suspend fun getPosts(): Response<List<Post>>
}