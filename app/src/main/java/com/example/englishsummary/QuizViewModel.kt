package com.example.englishsummary

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuizViewModel(
    private val repo: QuizRepo
) : ViewModel() {

     val quizLiveData = MutableLiveData<List<QuizItem>>()
    private val errorLiveData = MutableLiveData<String>()

    fun fetchQuizDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val fetchedQuizList = repo.getQuizQuestionsRepo()
                withContext(Dispatchers.Main) {
                    quizLiveData.value = fetchedQuizList
                    Log.i("Talha", "Quiz details fetched successfully: ${quizLiveData.value}")
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    errorLiveData.value = "Error fetching quiz details: ${e.message}"
                    Log.e("Talha", "Error fetching quiz details", e)
                }
            }
        }
    }
}
