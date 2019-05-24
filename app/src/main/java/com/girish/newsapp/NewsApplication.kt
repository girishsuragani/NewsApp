package com.girish.newsapp

import com.girish.newsapp.di.AppComponent
import com.girish.newsapp.di.AppModule
import com.girish.newsapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by Girish on 24/05/19.
 */
class NewsApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule())
                .build()
        appComponent.inject(this)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
    }


//    fun initDagger(): AppComponent {
//        val appComponent = DaggerAppComponent.builder()
//                .application(this)
//                .appModule(AppModule())
//                .build()
//        appComponent.inject(this)
//        return appComponent
//
//    }



}