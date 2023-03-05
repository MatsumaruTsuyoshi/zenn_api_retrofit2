package com.example.retrofit2_demo

import android.util.Log
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

    fun getArticles(): List<Article> {
        try {
            val response = service.getArticles().execute()
            if (response.isSuccessful) {
                return response.body()!!
            } else { // 失敗の時は今回は実装していません。
                Log.d("ArticleRepository", "GET ERROR")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return emptyList()
    }
}