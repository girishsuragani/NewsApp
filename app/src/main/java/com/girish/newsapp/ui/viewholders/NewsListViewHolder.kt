package com.girish.newsapp.ui.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import kotlinx.android.synthetic.main.newslist_item.view.*

/**
 * Created by Girish on 27/05/19.
 */
class NewsListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindView(newsDisplay: NewsArticle) {
        itemView.news_title.text = newsDisplay.title
        itemView.news_content.text = newsDisplay.description
    }
}