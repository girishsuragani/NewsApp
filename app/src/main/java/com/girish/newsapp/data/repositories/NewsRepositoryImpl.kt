package com.girish.newsapp.data.repositories

import com.girish.newsapp.data.db.FavoriteShowsDao
import com.girish.newsapp.data.mapper.FavNewsMapper
import com.girish.newsapp.data.network.NewsService
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.repository.NewsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Girish on 23/05/19.
 */
class NewsRepositoryImpl @Inject constructor(private val newsService: NewsService,private val favoriteShowsDao: FavoriteShowsDao,private val favNewsMapper: FavNewsMapper) : NewsRepository {

    override fun getTopHeadlines(country: String, category : String ,apiKey : String): Single<NewsList> {

        return newsService.getTopHeadlines(country,category,apiKey)
    }


    override fun getFavNews(): Single<List<NewsArticle>> {

        return favoriteShowsDao.getallFavouriteShows()
                .flatMap {
                    Single.just(it.map { favNewsMapper.mapFromEntity(it) })
                }
    }

    override fun saveFavNews(favnews: NewsArticle) {

        return favoriteShowsDao.insert(favNewsMapper.mapToEntity(favnews))

    }
}