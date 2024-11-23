package com.example.englishsummary
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class PostViewModel(
    private val repo: PostRepo
) : ViewModel() {
    var _listLiveData = MutableLiveData<PagingData<Post>>()
    val listLiveData: LiveData<PagingData<Post>> = _listLiveData

    fun fetchPostsDetail(categoryCode: Int) {
        viewModelScope.launch {
            val fetchedPosts = repo.getPosts(categoryCode).cachedIn(viewModelScope)
            Log.i("meeena","$fetchedPosts in viewmodel")
            _listLiveData = fetchedPosts as MutableLiveData<PagingData<Post>>
        }
    }
}


