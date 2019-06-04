package com.girish.newsapp.data.mapper

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList


class NewsMapper {
    fun map(newsListResponse: NewsList?) : List<NewsArticle>? {
        return  newsListResponse?.articles
    }
}