package com.girish.newsapp.data.network

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Girish on 23/05/19.
 */
interface NewsService{


    @GET("top-headlines")
    fun getTopHeadlines(@Query("country") country: String,@Query("category") category: String,@Query("apiKey") apiKey: String):
            Single<NewsList>



}