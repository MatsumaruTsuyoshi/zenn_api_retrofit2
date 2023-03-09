package com.example.retrofit2_demo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2_demo.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    // ViewModelの注入
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recyclerView
        binding.recyclerView.adapter = ArticleAdapter(emptyList())
        binding.recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        recyclerView.adapter = binding.recyclerView.adapter


        lifecycleScope.launch {
            viewModel.getArticles()
        }

        viewModel.articles.observe(this, Observer { it ->
            // recyclerViewのAdapterに、取得した記事の情報を渡す
            it?.let { recyclerView.adapter = ArticleAdapter(it) }
        })
    }
}