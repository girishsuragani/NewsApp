package com.girish.newsapp.ui.activities

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.girish.newsapp.R
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.ui.adapters.FavNewsAdapter
import com.girish.newsapp.ui.adapters.NewsListAdapter
import com.girish.newsapp.ui.viewmodels.FavNewsViewModel
import com.girish.newsapp.ui.viewmodels.NewsDisplayViewModel
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_favnews.*
import javax.inject.Inject

/**
 * Created by Girish on 28/05/19.
 */
class FavNewsActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: FavNewsViewModel

    private lateinit var adapter: FavNewsAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_favnews)
        initViews()
        initViewModel()
        getBookmarks()


    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)[FavNewsViewModel::class.java]
        viewModel.favnewsList.observe(this, Observer {
            it?.let {
            if (::adapter.isInitialized) {
            adapter.setData(it)
              }
            }
        })
    }

    private fun initViews() {
        adapter = FavNewsAdapter()
        rv_favnews.layoutManager = LinearLayoutManager(this)
        rv_favnews.adapter = adapter
    }


    private fun getBookmarks() {
        viewModel.getFavNews()
    }


}

