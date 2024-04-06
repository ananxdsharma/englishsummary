package com.example.englishsummary

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val repo: PostRepo
) : ViewModel() {
    private val categoryLiveData = MutableLiveData<List<Post>>()
    val categoryArchiveTitleListLiveData = MutableLiveData<CategoryArchive>()
    val isLoading = MutableLiveData<Boolean>(false)
    fun fetchCategoryArchive(categoryType: Int, noOfPost: Int) {
        viewModelScope.launch (Dispatchers.IO){
            isLoading.postValue(true)
            val fetchedCategoryArchive = repo.getArchivePosts(categoryType, noOfPost)
            if (fetchedCategoryArchive.isSuccessful) {
                val categoryList = fetchedCategoryArchive.body()
                // Make sure categoryLiveData is not empty before accessing its elements
                categoryList?.let { categoryList ->
                    if (categoryList.isNotEmpty()) {
                        // Accessing titles only if categoryLiveData has elements
                        val title1 = categoryList[0].title.rendered
                        val title2 = categoryList[1].title.rendered
                        val title3 = categoryList[2].title.rendered
                        Log.i("kung", " in viewmodel $categoryType")
                        val archiveTitleList = CategoryArchive(categoryType, title1, title2, title3)
                        categoryArchiveTitleListLiveData.postValue(archiveTitleList)
                        isLoading.postValue(false)
                    }
                }
            }
        }
    }
}


