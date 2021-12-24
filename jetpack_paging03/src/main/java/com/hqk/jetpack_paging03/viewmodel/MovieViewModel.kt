package com.hqk.jetpack_paging03.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hqk.jetpack_paging03.model.Movie
import com.hqk.jetpack_paging03.paging.MoviePagingSource
import kotlinx.coroutines.flow.Flow


class MovieViewModel : ViewModel() {

    private val movies by lazy {
        Pager(
            config = PagingConfig(pageSize = 8, prefetchDistance = 8, initialLoadSize = 16),
            pagingSourceFactory = { MoviePagingSource() })
            .flow   //转为Flow流
            .cachedIn(viewModelScope) //使其生命周期与ViewModel相互绑定
    }


    fun loadMovie(): Flow<PagingData<Movie>> = movies

}