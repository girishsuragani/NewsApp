package com.girish.newsapp.di

import android.app.Application
import com.girish.newsapp.NewsApplication
import com.girish.newsapp.ui.activities.NewsDisplayActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Girish on 24/05/19.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,ViewModelModule::class, ActivityBindingModule::class, AndroidSupportInjectionModule::class))
interface AppComponent : AndroidInjector<NewsApplication>{

     fun inject(activity: NewsDisplayActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        @BindsInstance fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }
}