package com.girish.newsapp.di

import com.girish.newsapp.ui.activities.NewsDisplayActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Girish on 24/05/19.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindActivity(): NewsDisplayActivity
}