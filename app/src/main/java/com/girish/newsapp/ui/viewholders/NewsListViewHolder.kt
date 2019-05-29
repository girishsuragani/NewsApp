package com.girish.newsapp.ui.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import kotlinx.android.synthetic.main.newslist_item.view.*

/**
 * Created by Girish on 27/05/19.
 */
class NewsListViewHolder(itemView: View,
                         private val onItemClickListener:
                         ((position: Int, newsArticle: NewsArticle?) -> Unit)?):
        RecyclerView.ViewHolder(itemView) {
    private var newsArticle: NewsArticle? = null

    init {
        itemView.favbutton.setOnClickListener {
            onItemClickListener?.invoke(adapterPosition, newsArticle)
        }
    }


    fun bindView(newsDisplay: NewsArticle) {
        newsArticle = newsDisplay
        itemView.news_title.text = newsDisplay.title
        itemView.news_content.text = newsDisplay.description
    }
}