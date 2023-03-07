package com.example.retrofit2_demo

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("trendTech")
    suspend fun getArticles(): List<Article>
}