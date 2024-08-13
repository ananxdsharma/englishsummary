package com.example.englishsummary

import retrofit2.http.GET

interface QuizApiService {

    @GET("questions?category=arts_and_literature&tags=arts_and_literature&difficulty=easy")
    suspend fun getQuizQuestions(): List<QuizItem>
}