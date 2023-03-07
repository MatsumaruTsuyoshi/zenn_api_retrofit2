package com.example.retrofit2_demo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ArticleAdapter

    // ViewModelの注入
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArticleAdapter(emptyList())
        recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.getArticles()
        }

        viewModel.articles.observe(this, Observer { it ->
            // recyclerViewのAdapterに、取得した記事の情報を渡す
            it?.let { recyclerView.adapter = ArticleAdapter(it) }
        })
    }
}