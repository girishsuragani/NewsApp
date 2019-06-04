package com.girish.newsapp.data.mapper

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import io.reactivex.Single


class NewsMapper {
    fun map(newsListResponse: NewsList) : Single<List<NewsArticle>?> {
        return  Single.just(newsListResponse.articles)
    }
}