package com.example.retrofit2_demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var articles = MutableLiveData<List<Article>>(emptyList())
    private val articleRepository: ArticleRepository = ArticleRepository()

    suspend fun getArticles() {
        val response = articleRepository.getArticlesSuspend()
        articles.value = response
    }
}