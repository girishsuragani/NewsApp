package com.girish.newsapp.ui.activities

/**
 * Created by Girish on 23/05/19.
 */
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log

import com.girish.newsapp.R
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.ui.viewmodels.NewsDisplayViewModel
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NewsDisplayActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: NewsDisplayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)[NewsDisplayViewModel::class.java]
          viewModel.newsList.observe(this, Observer { it?.let { setNewsList(it) } })
        viewModel.getNews("us")
    }

    private fun setNewsList(newsList: NewsList) {



        Log.d("Articles", "hiii" + newsList.toString())


    }

}


