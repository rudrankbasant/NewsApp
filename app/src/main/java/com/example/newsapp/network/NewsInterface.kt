package com.example.newsapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "272e0f00d82149ceaa5ed28d7d644d95"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page")page: Int): Call<NewsData>


}