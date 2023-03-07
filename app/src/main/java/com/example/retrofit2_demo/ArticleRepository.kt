package com.example.retrofit2_demo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException

class ArticleRepository {
    private val service: ApiService = Retrofit.Builder()
        .baseUrl("https://zenn-api.vercel.app/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()

    suspend fun getArticlesSuspend(): List<Article>? {
        try {
            return service.getArticles()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}