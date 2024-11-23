package com.example.englishsummary

import androidx.paging.PagingSource
import androidx.paging.PagingState

class PostPagingSource( val postApiService: PostApiService,private  val categorycode:Int) :
    PagingSource<Int, Post>() {
    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return  state.anchorPosition?.let{
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?:state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return try{
            val position=params.key?:1
            val response=postApiService.getPosts(categorycode,position)
            val posts=response.body() ?: emptyList()
            LoadResult.Page(
                data = posts,
                prevKey = if (position == 1) null else position - 1,
                nextKey = position + 1
            )

        } catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}