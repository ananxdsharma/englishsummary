package com.example.englishsummary

class PostRepo(
    private val postapiService: PostApiService
) {
    suspend fun getPosts(kp:Int)= postapiService.getPosts(kp)
    suspend fun getArchivePosts(kp: Int,noOfPost:Int)=postapiService.getArchivePosts(kp,noOfPost)

}

