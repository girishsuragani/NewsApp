package com.girish.newsapp.di

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.girish.newsapp.ui.viewmodels.FavNewsViewModel
import com.girish.newsapp.ui.viewmodels.NewsDisplayViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

/**
 * Created by Girish on 24/05/19.
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsDisplayViewModel::class)
    abstract fun provideViewModel(newsDisplayViewModel: NewsDisplayViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(FavNewsViewModel::class)
    abstract fun provideFavViewModel(favNewsViewModel: FavNewsViewModel): ViewModel
}

@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)