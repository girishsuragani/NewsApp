package com.girish.newsapp.domain.repository

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList


import io.reactivex.Single

interface NewsRepository{
    fun getTopHeadlines(country: String): Single<NewsList?>

}