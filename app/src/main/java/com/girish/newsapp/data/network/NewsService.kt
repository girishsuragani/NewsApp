package com.girish.newsapp.data.network

import com.girish.newsapp.domain.model.NewsList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService{


    @GET("top-headlines")
    fun getTopHeadlines(@Query("country") country: String, @Query("apiKey") apiKey: String):
            Single<NewsList?>



}
