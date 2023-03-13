package com.example.retrofit2_demo

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("trendTech")
    suspend fun getArticles(): Response<List<Article>>
}