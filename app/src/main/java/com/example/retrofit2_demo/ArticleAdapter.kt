package com.example.retrofit2_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2_demo.databinding.ItemListBinding

class ArticleAdapter(
    private val articles: List<Article>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<ArticleAdapter.BindingHolder>() {

    inner class BindingHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater)
        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val item = articles[position]
        holder.binding.title.text = item.title
        holder.binding.title.setOnClickListener {
            listener.onItemClickListener(it, item.getUrl())
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    //インターフェースの作成
    interface OnItemClickListener {
        fun onItemClickListener(view: View, url: String)
    }

}