package com.girish.newsapp.domain.usecases

import com.girish.newsapp.BuildConfig
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.repository.NewsRepository
import com.girish.newsapp.domain.usecases.base.SingleUseCase
import com.girish.newsapp.domain.usecases.base.SingleUseCaseWithParameter
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Girish on 28/05/19.
 */
class GetFavNewsUseCase @Inject constructor(val favnewsrepo: NewsRepository)
    : SingleUseCase<List<NewsArticle>> {

    override fun execute(): Single<List<NewsArticle>> {
        return favnewsrepo.getFavNews()
    }

}