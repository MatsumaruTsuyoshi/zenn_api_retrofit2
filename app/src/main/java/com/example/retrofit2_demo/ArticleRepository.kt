package com.example.retrofit2_demo

import java.io.IOException
import javax.inject.Inject


class ArticleRepository @Inject constructor(private val service: ApiService) : ApiService {

    override suspend fun getArticles(): List<Article> {
        try {
            return service.getArticles()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return emptyList()
    }
}