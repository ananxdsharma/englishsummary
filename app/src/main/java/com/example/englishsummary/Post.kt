package com.example.englishsummary

data class Post(
    val content: Content,
    val excerpt: Excerpt,
    val id: Int,
    val link: String,
    val title: Title
)