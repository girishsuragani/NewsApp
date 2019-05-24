package com.girish.newsapp.ui.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.usecases.GetTopHeadlinesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Girish on 23/05/19.
 */

class NewsDisplayViewModel @Inject constructor(val getTopHeadlinesUseCase: GetTopHeadlinesUseCase): ViewModel() {

    val newsList = MutableLiveData<NewsList>()

    fun getNews(country:String) {
        getTopHeadlinesUseCase.execute(country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    newsList.postValue(it)
                }, {
                    it.printStackTrace()
                })
    }

}