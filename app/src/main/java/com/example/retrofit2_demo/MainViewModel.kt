package com.example.retrofit2_demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var articles = MutableLiveData<List<Article>>(emptyList())
    private val articleRepository: ArticleRepository = ArticleRepository()

    fun getArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            articles.value = articleRepository.getArticles()
        }
    }

}