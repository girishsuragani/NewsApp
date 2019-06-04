package com.girish.newsapp.data.repository

import com.girish.newsapp.BuildConfig
import com.girish.newsapp.data.network.NewsService
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.repository.NewsRepository
import com.girish.newsapp.domain.usecases.GetTopHeadlinesUseCase
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class NewsRepoImplTest{



    @Mock
    private lateinit var newsService: NewsService

    @InjectMocks
    private lateinit var newsRepositoryImpl: NewsRepoImpl


    private lateinit var country: String
    private var newsList: NewsList? = null
    private var newsArticleList: ArrayList<NewsArticle>? = ArrayList()

    @Before
   fun setUp() {

        country = "us"
        newsArticleList?.add(NewsArticle("Softbank's Vision Fund Unexpectedly Takes Out $4 Billion Margin Loan Against Uber Shares",
                "In what appears to be an attempt skirt the lock-up on newly listed Uber shares, Softbank's Vision Fund is planning to borrow $4 billion against its shares of the ride hailing company. The fund is currently in talks with Goldman Sachs to arrange the loan, whic…"))
        newsList = NewsList("ok", "38", newsArticleList)



    }



    @Test
    fun checkInjection()
    {
        assertNotNull(newsRepositoryImpl)

    }



    @Test
    fun `execute is success`()
    {
        `when`(newsService.getTopHeadlines(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(Single.just(newsList))
        newsRepositoryImpl.getTopHeadlines(country).test()
                .assertSubscribed()
                .assertComplete()
                .assertNoErrors()
                .assertValueCount(1)
                .assertResult(newsList)
        Mockito.verify(newsService, Mockito.times(1)).getTopHeadlines(ArgumentMatchers.anyString(),ArgumentMatchers.anyString())



    }


}