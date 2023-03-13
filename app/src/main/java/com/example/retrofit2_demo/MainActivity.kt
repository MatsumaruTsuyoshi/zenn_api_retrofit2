package com.example.retrofit2_demo

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2_demo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch

@HiltAndroidApp
class MainApplication : Application()

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ArticleAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArticleAdapter

    // ViewModelの注入
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recyclerView
        adapter = ArticleAdapter(emptyList(), this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        recyclerView.adapter = binding.recyclerView.adapter

        lifecycleScope.launch {
            viewModel.getArticles()
        }

        viewModel.articles.observe(this) { it ->
            // recyclerViewのAdapterに、取得した記事の情報を渡す
            it?.let { recyclerView.adapter = ArticleAdapter(it, this) }
        }
    }

    override fun onItemClickListener(view: View, url: String) {
        val intent = Intent(applicationContext, ArticleActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }

}