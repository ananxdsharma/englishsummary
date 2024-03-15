package com.example.englishsummary
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PostViewModel(
    private val repo: PostRepo
) : ViewModel() {
    val postLiveData = MutableLiveData<List<Post>>()

    fun fetchPostsDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            val fetchedPosts = repo.getPosts()
            if(fetchedPosts.isSuccessful){
                postLiveData.postValue(fetchedPosts.body())
            }
        }
    }
}


