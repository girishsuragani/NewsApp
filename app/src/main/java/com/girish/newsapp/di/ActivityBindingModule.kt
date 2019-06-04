package com.girish.newsapp.di

import com.girish.newsapp.ui.activities.NewsDisplayActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindActivity(): NewsDisplayActivity
}