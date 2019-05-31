package com.girish.newsapp.domain.usecases

import com.girish.newsapp.domain.repository.NewsRepository
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

class SaveFavNewsUseCaseTest {

    @Mock
    private lateinit var newsRepository : NewsRepository

    @InjectMocks
    private lateinit var saveFavNewsUseCase: SaveFavNewsUseCase


    @Before
    fun setUp() {



    }


}