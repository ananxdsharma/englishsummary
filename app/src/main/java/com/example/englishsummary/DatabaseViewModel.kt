package com.example.englishsummary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DatabaseViewModel(
    private val repo: DatabaseRepo
) : ViewModel() {

    suspend fun insertInEnglishLiterature(cDetail: EnglishLiteratureData) {
        viewModelScope.launch(Dispatchers.IO) { repo.insertInEnglishLiterature(cDetail) }
    }
    fun deleteInEnglishLiterature(cDetail: EnglishLiteratureData) {
        viewModelScope.launch(Dispatchers.IO) { repo.deleteInEnglishLiterature(cDetail) }
    }
    fun getcIdInEnglishLiterature(str: String) = repo.getCategoryIdInEnglishLiterature(str)

    fun getcNameInEnglishLiterature(i: Int) = repo.getCategoryNameInEnglishLiterature(i)



    suspend fun insertInEnglishGrammer(cDetail: EnglishGrammerData) {
        viewModelScope.launch(Dispatchers.IO) { repo.insertInEnglishGrammer(cDetail) }
    }
    fun deleteInEnglishGrammer(cDetail: EnglishGrammerData) {
        viewModelScope.launch(Dispatchers.IO) { repo.deleteInEnglishGrammer(cDetail) }
    }
    fun getcIdInEnglishGrammer(str: String) = repo.getCategoryIdInEnglishGrammer(str)

    fun getcNameInEnglishGrammer(i: Int) = repo.getCategoryNameInEnglishGrammer(i)



    fun insertInIndianBoards(cDetail: IndianBoardsData) {
        viewModelScope.launch(Dispatchers.IO) { repo.insertInIndianBoards(cDetail) }
    }
    fun deleteInIndianBoards(cDetail: IndianBoardsData) {
        viewModelScope.launch(Dispatchers.IO) { repo.deleteInIndianBoards(cDetail) }
    }
    fun getcIdInIndianBoards(str: String) = repo.getCategoryIdInIndianBoards(str)

    fun getcNameInIndianBoards(i: Int) = repo.getCategoryNameInIndianBoards(i)


}