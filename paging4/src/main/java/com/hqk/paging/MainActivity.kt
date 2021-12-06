package com.hqk.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.hqk.paging.model.Movie
import com.hqk.paging.paging.MoviePagedListAdapter
import com.hqk.paging.paging.MovieViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = MoviePagedListAdapter(this)
        recyclerView.adapter = adapter

        val movieViewModel = MovieViewModel(application)

        movieViewModel.moviePagedList!!.observe(this, Observer<PagedList<Movie>> {
            adapter.submitList(it)
        })

        findViewById<SwipeRefreshLayout>(R.id.swipeRefresh).also {
            it.setOnRefreshListener {
                movieViewModel.refresh()
                it.isRefreshing = false
            }
        }
    }
}