package com.girish.newsapp.domain.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

/**
 * Created by Girish on 23/05/19.
 */
data class NewsList(
        @SerializedName( "status") val status: String?,
        @SerializedName( "totalResults") val totalResults: String?,
        @SerializedName( "articles") var articles: List<NewsArticle>?
)