package com.example.retrofit2_demo

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit2_demo.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var url = ""

        val arg = intent.getStringExtra("url").let { it }

        if (arg != null) {
            url = arg
        }

        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mWebView = binding.webViewActivity
        mWebView.settings.javaScriptEnabled = true
        mWebView.webViewClient = WebViewClient()
        mWebView.loadUrl(url)
    }
}