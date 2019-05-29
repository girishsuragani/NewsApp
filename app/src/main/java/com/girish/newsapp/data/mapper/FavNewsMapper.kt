package com.girish.newsapp.data.mapper

import com.girish.newsapp.data.db.FavoriteShows
import com.girish.newsapp.domain.model.NewsArticle
import javax.inject.Inject

/**
 * Created by Girish on 28/05/19.
 */


open class FavNewsMapper @Inject constructor(): Mapper<FavoriteShows, NewsArticle> {


    override fun mapFromEntity(type: FavoriteShows): NewsArticle {
        return NewsArticle( type.title, type.description)
    }


    override fun mapToEntity(type: NewsArticle): FavoriteShows {
        return FavoriteShows(type.title, type.description)
    }


}