package com.girish.newsapp.domain.usecases

import com.girish.newsapp.BuildConfig
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.repository.NewsRepository
import com.girish.newsapp.domain.usecases.base.SingleUseCaseWithParameter
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Girish on 23/05/19.
 */
class GetTopHeadlinesUseCase @Inject constructor(val newsRepository: NewsRepository)
    : SingleUseCaseWithParameter<String, NewsList> {

    override fun execute(parameter: String): Single<NewsList> {
        return newsRepository.getTopHeadlines(parameter, "business", BuildConfig.ApiKey)
    }

}