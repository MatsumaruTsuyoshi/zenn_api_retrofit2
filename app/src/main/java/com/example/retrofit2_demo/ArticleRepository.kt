package com.example.retrofit2_demo

import javax.inject.Inject


class ArticleRepository @Inject constructor(private val service: ApiService) {

    suspend fun getArticles(): NetworkResult<List<Article>> {
        return handleApi { service.getArticles() }
    }
}