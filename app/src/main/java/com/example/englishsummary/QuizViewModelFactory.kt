package com.example.englishsummary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuizViewModelFactory(
    private val repo: QuizRepo
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuizViewModel(repo) as T
    }


}