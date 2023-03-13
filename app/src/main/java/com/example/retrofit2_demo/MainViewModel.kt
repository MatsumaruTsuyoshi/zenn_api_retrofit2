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
        when (val response = articleRepository.getArticles()) {
            is NetworkResult.Success -> articles.value = response.data
            is NetworkResult.Error -> println("${response.code} ${response.message}")
            is NetworkResult.Exception -> println("${response.e.message}")
        }
    }
}