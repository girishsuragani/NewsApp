package com.girish.newsapp.data.repository

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject


class NewsRepoImpl : NewsRepository{
    override fun getTopHeadlines(country: String): Single<List<NewsArticle>?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.




    }


}