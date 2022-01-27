package com.example.newsapp.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.network.ArticlesData

class NewsAdapter(val context: Context, val articles: List<ArticlesData>): Adapter<NewsAdapter.articleViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): articleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return articleViewHolder(view)
    }


    override fun onBindViewHolder(holder: articleViewHolder, position: Int) {
        val articles = articles[position]
        holder.newsTitle.text =articles.title
        holder.newsDesc.text=articles.description
        Glide.with(context).load(articles.urlToImage).into(holder.newsImage)
        holder.itemView.setOnClickListener{
            Toast.makeText(context,"This item was clicked",Toast.LENGTH_SHORT).show()
        }
    }


    override fun getItemCount(): Int {
        return articles.size
    }


    class articleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var newsImage= itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle= itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDesc= itemView.findViewById<TextView>(R.id.newsDescription)


    }
}