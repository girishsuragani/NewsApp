package com.girish.newsapp.ui.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.usecases.GetFavNewsUseCase
import com.girish.newsapp.domain.usecases.GetTopHeadlinesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Girish on 28/05/19.
 */


class FavNewsViewModel @Inject constructor( val getFavNewsUseCase: GetFavNewsUseCase): ViewModel() {

    val favnewsList = MutableLiveData<List<NewsArticle>>()

    fun getFavNews() {
        getFavNewsUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    favnewsList.postValue(it)
                }, {
                    it.printStackTrace()
                })
    }

}