package com.girish.newsapp.domain.usecases

import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.domain.repository.NewsRepository
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetTopHeadlinesUseCaseTest{


    @Mock
    private lateinit var newsRepository: NewsRepository

    @InjectMocks
    private lateinit var getTopHeadlinesUseCase: GetTopHeadlinesUseCase



    private lateinit var country : String
    private var newsList: NewsList? = null
    private var newsarticlelist: ArrayList<NewsArticle>? = ArrayList()



    @Before
    fun setUp()
    {

        country = "us"
        newsarticlelist?.add(NewsArticle("Softbank's Vision Fund Unexpectedly Takes Out $4 Billion Margin Loan Against Uber Shares",
                "In what appears to be an attempt skirt the lock-up on newly listed Uber shares, Softbank's Vision Fund is planning to borrow $4 billion against its shares of the ride hailing company. The fund is currently in talks with Goldman Sachs to arrange the loan, whic…"))
        newsList = NewsList("ok","50",newsarticlelist)


    }

    @Test
    fun checkInjection()
    {
        assertNotNull(getTopHeadlinesUseCase)

    }


    @Test
    fun `execute is success`()
    {
      `when`(newsRepository.getTopHeadlines(ArgumentMatchers.anyString())).thenReturn(Single.just(newsarticlelist))
        getTopHeadlinesUseCase.execute(country).test()
                .assertSubscribed()
                .assertComplete()
                .assertNoErrors()
                .assertValue(newsarticlelist)
        verify(newsRepository, times(1)).getTopHeadlines(ArgumentMatchers.anyString())

    }




}