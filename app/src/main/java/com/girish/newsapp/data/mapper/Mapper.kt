package com.girish.newsapp.data.mapper

/**
 * Created by Girish on 28/05/19.
 */
interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E

}