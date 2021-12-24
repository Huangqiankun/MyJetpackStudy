package com.hqk.jetpack_paging03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hqk.jetpack_paging03.databinding.MovieItemBinding
import com.hqk.jetpack_paging03.model.Movie


class MovieAdapter(private val context: Context) :
    PagingDataAdapter<Movie, BindingViewHolder>(object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            // kotlin === 引用 ， == 内容
            // Java == 引用， equals 内容
            return oldItem == newItem
        }

    }) {
    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let {
            val binding = holder.binding as MovieItemBinding
            binding.movie = it
            binding.networkImage = it.cover
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(binding)
    }

}