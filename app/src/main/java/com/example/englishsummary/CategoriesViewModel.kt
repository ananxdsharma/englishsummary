package com.example.englishsummary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CategoriesViewModel(
    private val repo: PostRepo
) : ViewModel() {
    val categoryLiveData = MutableLiveData<List<Post>>()
    var cID: Int = -1

    fun fetchCategoryArchive(categoryType: Int, noOfPost: Int) {



        viewModelScope.launch {
            try {
                // Execute the synchronous API call in the IO dispatcher
                val fetchedCategoryArchive = withContext(Dispatchers.IO) {
                    repo.getArchivePosts(categoryType, noOfPost)
                }
                if (fetchedCategoryArchive.isSuccessful) {
                    categoryLiveData.postValue(fetchedCategoryArchive.body())


                    Log.i("anand", "the data is coming -- $categoryType")
                } else {
                    Log.i("anand", "the data is not coming")
                }
            } catch (e: Exception) {
                Log.e("anand", "Error fetching category archive: ${e.message}", e)
            }
        }
    }
}
