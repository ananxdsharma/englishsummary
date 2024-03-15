package com.example.englishsummary

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object{
        private var postapiservices: PostApiService? =null
        fun getInstance(): PostApiService {
            if(postapiservices==null){
                postapiservices= Retrofit.Builder()
                    .baseUrl("https://englishsummary.com/wp-json/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PostApiService::class.java)


            }
            return postapiservices!!
        }
    }
}