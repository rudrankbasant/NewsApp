package com.example.newsapp.network

data class NewsData(
    val totalResults: Int,
    val articles: List<ArticlesData>
)
