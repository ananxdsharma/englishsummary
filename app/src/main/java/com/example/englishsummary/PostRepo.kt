package com.example.englishsummary

class PostRepo(
    private val postapiService: PostApiService

) {

    // Api Interface
    suspend fun getPosts(kp: Int) = postapiService.getPosts(kp)
    suspend fun getArchivePosts(kp: Int, noOfPost: Int) =
        postapiService.getArchivePosts(kp, noOfPost)


}

