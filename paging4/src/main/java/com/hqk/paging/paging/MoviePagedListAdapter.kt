package com.hqk.paging.paging

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hqk.paging.R
import com.hqk.paging.model.Movie
import com.hqk.paging.paging.MoviePagedListAdapter.*
import com.squareup.picasso.Picasso

class MoviePagedListAdapter : PagedListAdapter<Movie, MovieViewHolder> {


    //<html>None of the following functions can be called with the arguments supplied:<br/>protected/*protected and package*/ constructor PagedListAdapter&lt;T : Any!, VH : RecyclerView.ViewHolder!&gt;(config: AsyncDifferConfig&lt;Movie!&gt;) defined in androidx.paging.PagedListAdapter<br/>protected/*protected and package*/ constructor PagedListAdapter&lt;T : Any!, VH : RecyclerView.ViewHolder!&gt;(diffCallback: DiffUtil.ItemCallback&lt;Movie!&gt;) defined in androidx.paging.PagedListAdapter

    private var context: Context? = null


    constructor(context: Context) : super(DIFF_CALLBACK) {
        this.context = context
    }

    companion object {
        //差分，只更新需要更新的元素，而不是整个刷新数据源
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Movie> =
            object : DiffUtil.ItemCallback<Movie>() {
                override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                    return oldItem === newItem
                }

                override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                    return oldItem == newItem
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MovieViewHolder(root)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            Picasso.get()
                .load(movie.cover)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView)
            if (movie.title!!.length >= 8) {
                movie.title = movie.title!!.substring(0, 7)
            }
            holder.textViewTitle!!.text = movie.title
            holder.textViewRate!!.text = movie.rate
        }
    }

    class MovieViewHolder : RecyclerView.ViewHolder {
        var imageView: ImageView? = null
        var textViewTitle: TextView? = null
        var textViewRate: TextView? = null

        constructor(itemView: View) : super(itemView) {
            imageView = itemView.findViewById(R.id.imageView)
            textViewTitle = itemView.findViewById(R.id.textViewTitle)
            textViewRate = itemView.findViewById(R.id.textViewRate)
        }
    }

}