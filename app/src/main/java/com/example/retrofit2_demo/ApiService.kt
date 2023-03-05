package com.example.retrofit2_demo

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("trendTech")
    fun getArticles(): Call<List<Article>>
}