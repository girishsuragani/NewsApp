package com.girish.newsapp.data.repository

import com.girish.newsapp.BuildConfig
import com.girish.newsapp.data.mapper.NewsMapper
import com.girish.newsapp.data.network.NewsService
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject


class NewsRepoImpl @Inject constructor(private val newsService: NewsService) : NewsRepository{


    override fun getTopHeadlines(country: String): Single<NewsList?> {


        return  newsService.getTopHeadlines(country, BuildConfig.ApiKey)



    }


}