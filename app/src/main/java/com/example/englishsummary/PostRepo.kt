package com.example.englishsummary

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class PostRepo(
    private val postapiService: PostApiService

) {
    //paging and getPosts()
    fun getPosts(categoryCode:Int)= Pager(
        config = PagingConfig(pageSize = 5, maxSize = 30),
        pagingSourceFactory = { PostPagingSource(postapiService,categoryCode)}
    ).liveData
    // Api Interface
//    suspend fun getPosts(kp: Int,pNO:Int) = postapiService.getPosts(kp,pNO)
    suspend fun getArchivePosts(kp: Int, noOfPost: Int) =
        postapiService.getArchivePosts(kp, noOfPost)


}

