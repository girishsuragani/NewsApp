package com.girish.newsapp.domain.usecases.base

import io.reactivex.Single

interface SingleUseCaseWIthParam <P,R>
{
    fun execute(parameter:P): Single<R>
}