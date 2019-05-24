package com.girish.newsapp.di

import android.content.Context
import com.girish.newsapp.NewsApplication
import com.girish.newsapp.data.di.DataModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Girish on 24/05/19.
 */
@Module(includes = arrayOf(DataModule::class))
class AppModule {





}