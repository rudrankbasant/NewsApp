package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.network.NewsData
import com.example.newsapp.network.NewsSingleton
import com.example.newsapp.recyclerView.NewsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsList = findViewById<RecyclerView>(R.id.recyclerView)
        newsList.layoutManager = LinearLayoutManager(this@MainActivity)


        val news: Call<NewsData> = NewsSingleton.newsInstance.getHeadlines("in",1)
            news.enqueue(object: Callback<NewsData>{
                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {

                    adapter= NewsAdapter(this@MainActivity, response.body()!!.articles)
                    newsList.adapter= adapter
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    Log.d("oops", "failure!")
                }

            })





    }


}