package com.girish.newsapp.domain.usecases

import com.girish.newsapp.BuildConfig
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.repository.NewsRepository
import io.reactivex.Single
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetTopHeadlinesUseCaseTest {

    @Mock
    private lateinit var newsRepository : NewsRepository

    @InjectMocks
    private lateinit var getTopHeadlinesUseCase: GetTopHeadlinesUseCase


    private lateinit var country : String
    private lateinit var category : String
    private lateinit var newsList: NewsList
    private lateinit var newsarticle: ArrayList<NewsArticle>



    @Before
    fun setUp()
    {
        country = "us"
        newsarticle = ArrayList()

        newsarticle.add(NewsArticle("Softbank's Vision Fund Unexpectedly Takes Out $4 Billion Margin Loan Against Uber Shares",
                "In what appears to be an attempt skirt the lock-up on newly listed Uber shares, Softbank's Vision Fund is planning to borrow $4 billion against its shares of the ride hailing company. The fund is currently in talks with Goldman Sachs to arrange the loan, whic…"))

        newsList = NewsList("ok","50",newsarticle)


    }

    @Test
    fun checkInjection() {
        assertNotNull(getTopHeadlinesUseCase)
    }

    @Test
    fun `Response is success`()
    {
        `when`(newsRepository.getTopHeadlines(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString())).thenReturn(Single.just(newsList))
        getTopHeadlinesUseCase.execute(country).test()!!
                .assertSubscribed()
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .assertResult(newsList)
        verify(newsRepository, times(1)).getTopHeadlines(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString())

    }


    @Test(expected = Exception::class)
    fun `Response is error`()
    {
        `when`(newsRepository.getTopHeadlines(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString()))
                .thenThrow(Exception("Unable to get response"))
        getTopHeadlinesUseCase.execute(country).test()
                .assertError(Exception("Unable to get response"))
        verify(newsRepository, times(1)).getTopHeadlines(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString())
    }
}