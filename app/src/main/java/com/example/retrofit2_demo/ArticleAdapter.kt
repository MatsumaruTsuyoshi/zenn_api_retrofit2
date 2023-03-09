package com.example.retrofit2_demo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2_demo.databinding.ItemListBinding

class ArticleAdapter(private val articles: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = articles[position]
        holder.title.text = item.title
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}