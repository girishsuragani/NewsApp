package com.girish.newsapp.domain.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

/**
 * Created by Girish on 23/05/19.
 */
data class NewsArticle(
        //@SerializedName( "author") var author: String,
        @SerializedName( "title") var title: String,
        @SerializedName("description") var description: String
//        @SerializedName("content") var content: String,
//        @SerializedName("url") var url: String,
//        @SerializedName("urlToImage") var urlToImage: String,
//        @SerializedName("publishedAt") var publishedAt: String
//
)