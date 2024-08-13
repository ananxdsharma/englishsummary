package com.example.englishsummary

import com.example.englishsummary.QuizApiService

class QuizRepo(
    private val quizapi: QuizApiService
) {
    suspend fun getQuizQuestionsRepo():List<QuizItem>{
        return  quizapi.getQuizQuestions()
    }
}