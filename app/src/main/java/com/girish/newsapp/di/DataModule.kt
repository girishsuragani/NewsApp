package com.girish.newsapp.di

import com.girish.newsapp.data.repositories.NewsRepositoryImpl
import com.girish.newsapp.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module

/**
 * Created by Girish on 24/05/19.
 */
@Module(includes = arrayOf(NetworkModule::class))
abstract class DataModule {

    @Binds
    abstract fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository


}


