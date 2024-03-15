package com.example.englishsummary

class PostRepo(
    private val postapiService: PostApiService
) {
    suspend fun getPosts()= postapiService.getPosts()
}

