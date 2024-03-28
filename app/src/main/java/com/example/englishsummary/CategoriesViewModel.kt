package com.example.englishsummary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class CategoriesViewModel(
    private val repo: PostRepo
) : ViewModel() {
    val categoryLiveData = MutableLiveData<List<Post>>()
    private val _cID = MutableLiveData<Int>()
    var cID: Int = 0




    suspend fun fetchCategoryArchive(categoryType: Int, noOfPost: Int) {
        viewModelScope.launch {
           cID=categoryType
            Log.i("kung", " in viewmodel $categoryType")
            val fetchedCategoryArchive = repo.getArchivePosts(categoryType, noOfPost)
            if (fetchedCategoryArchive.isSuccessful) {
                categoryLiveData.postValue(fetchedCategoryArchive.body())
            }
        }

    }
}


