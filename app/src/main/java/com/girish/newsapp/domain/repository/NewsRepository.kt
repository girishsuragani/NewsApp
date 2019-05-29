package com.girish.newsapp.domain.repository

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Girish on 23/05/19.
 */
interface NewsRepository{
    fun getTopHeadlines(country: String, category : String , apiKey : String): Single<NewsList>

    fun getFavNews(): Single<List<NewsArticle>>

    fun saveFavNews(favnews: NewsArticle)

}

