package com.girish.newsapp.di

import android.arch.persistence.room.Room
import android.content.Context
import com.girish.newsapp.data.db.FavoriteShowsDao
import com.girish.newsapp.data.db.NewsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Girish on 28/05/19.
 */
@Module
class NewsDatabaseModule {
    @Singleton
    @Provides
    fun provideNewsDatabase(context: Context): NewsDatabase {
        return Room.databaseBuilder(context,
                NewsDatabase::class.java, NewsDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }

    @Singleton
    @Provides
    fun provideFavoriteShowDao(newsDatabase: NewsDatabase): FavoriteShowsDao {
        return newsDatabase.favoriteShowsDao()
    }
}
