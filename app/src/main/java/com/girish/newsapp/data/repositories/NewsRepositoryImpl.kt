package com.girish.newsapp.data.repositories

import com.girish.newsapp.data.network.NewsService
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Girish on 23/05/19.
 */
class NewsRepositoryImpl @Inject constructor(private val newsService: NewsService) : NewsRepository {

    override fun getTopHeadlines(country: String, category : String ,apiKey : String): Single<NewsList> {

        return newsService.getTopHeadlines(country,category,apiKey)
    }

}