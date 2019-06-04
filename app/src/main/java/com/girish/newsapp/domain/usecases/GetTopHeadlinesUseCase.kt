package com.girish.newsapp.domain.usecases

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.repository.NewsRepository
import com.girish.newsapp.domain.usecases.base.SingleUseCaseWIthParam
import io.reactivex.Single
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor( val newsRepository: NewsRepository):  SingleUseCaseWIthParam<String, List<NewsArticle>?>{


    override fun execute(parameter: String): Single<List<NewsArticle>?> {

        return newsRepository.getTopHeadlines(parameter)




    }


}