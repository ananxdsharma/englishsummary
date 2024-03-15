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
    val isLoading = MutableLiveData<Boolean>(false)

    fun fetchPostsDetail() {
        viewModelScope.launch(Dispatchers.IO) {

            isLoading.postValue(true)
            val fetchedPosts = repo.getPosts()
            if(fetchedPosts.isSuccessful){
                postLiveData.postValue(fetchedPosts.body())
                isLoading.postValue(true)
            }
        }
    }
}


