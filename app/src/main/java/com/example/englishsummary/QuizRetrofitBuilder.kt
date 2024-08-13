package com.example.englishsummary

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuizRetrofitBuilder {

    companion object{
        private var quizapi: QuizApiService? =null
        fun getInstance(): QuizApiService {
            if(quizapi==null){
                quizapi= Retrofit.Builder()
                    .baseUrl("https://the-trivia-api.com/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(QuizApiService::class.java)


            }
            return quizapi!!
        }
    }
}