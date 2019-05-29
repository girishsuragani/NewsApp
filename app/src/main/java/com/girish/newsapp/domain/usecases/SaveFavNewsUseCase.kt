package com.girish.newsapp.domain.usecases

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.repository.NewsRepository
import com.girish.newsapp.domain.usecases.base.UseCase
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by Girish on 28/05/19.
 */
class SaveFavNewsUseCase @Inject constructor(val favnewsrepo: NewsRepository)
    : UseCase<NewsArticle> {
    override fun execute(newsArticle: NewsArticle) {
        return favnewsrepo.saveFavNews(newsArticle)
    }

}