package com.girish.newsapp.domain.usecases.base

import io.reactivex.Single

/**
 * Created by Girish on 23/05/19.
 */
interface SingleUseCaseWithParameter<P, R> {

    fun execute(parameter: P): Single<R>
}