package com.girish.newsapp.domain.usecases.base

import io.reactivex.Single

/**
 * Created by Girish on 28/05/19.
 */
interface SingleUseCase<T> {

    fun execute():Single<T>
}