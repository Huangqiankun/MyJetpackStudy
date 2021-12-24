package com.hqk.jetpack_paging03.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.hqk.jetpack_paging03.adapter.MovieAdapter
import com.hqk.jetpack_paging03.adapter.MovieLoadMoreAdapter
import com.hqk.jetpack_paging03.databinding.ActivityMainBinding
import com.hqk.jetpack_paging03.viewmodel.MovieViewModel
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    private val movieViewModel by viewModels<MovieViewModel>()

    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        val movieAdapter = MovieAdapter(this)

        mBinding.apply {
            recyclerView.adapter = movieAdapter.withLoadStateFooter(MovieLoadMoreAdapter(this@MainActivity))
            swipeRefreshLayout.setOnRefreshListener {
                movieAdapter.refresh()
            }
        }

        lifecycleScope.launchWhenCreated {
            movieViewModel.loadMovie().collectLatest {
                movieAdapter.submitData(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            movieAdapter.loadStateFlow.collectLatest { state ->
                mBinding.swipeRefreshLayout.isRefreshing = state.refresh is LoadState.Loading
            }
        }
    }
}