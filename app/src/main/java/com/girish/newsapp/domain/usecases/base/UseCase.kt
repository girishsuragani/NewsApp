package com.girish.newsapp.domain.usecases.base

import com.girish.newsapp.R
import io.reactivex.Single

/**
 * Created by Girish on 28/05/19.
 */
interface UseCase<P> {

    fun execute(parameter: P)
}