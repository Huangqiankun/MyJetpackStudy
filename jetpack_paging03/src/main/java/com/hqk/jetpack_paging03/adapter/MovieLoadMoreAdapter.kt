package com.hqk.jetpack_paging03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.hqk.jetpack_paging03.adapter.BindingViewHolder
import com.hqk.jetpack_paging03.databinding.MovieLoadmoreBinding


class MovieLoadMoreAdapter(private val context: Context) : LoadStateAdapter<BindingViewHolder>() {

    override fun onBindViewHolder(holder: BindingViewHolder, loadState: LoadState) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): BindingViewHolder {
        val binding = MovieLoadmoreBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(binding)
    }
}