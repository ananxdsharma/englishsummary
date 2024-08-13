package com.example.englishsummary

data class QuizItem(
    val category: String,
    val id: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>,
    val question: Question,
    val tags: List<String>,
    val type: String,
    val difficulty: String,
    val regions: List<Any>,
    val isNiche: Boolean
)