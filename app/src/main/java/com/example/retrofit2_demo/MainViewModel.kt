package com.example.retrofit2_demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel() {

    var articles = MutableLiveData<List<Article>>(emptyList())

    suspend fun getArticles() {
        val response = articleRepository.getArticles()
        articles.value = response
    }

}