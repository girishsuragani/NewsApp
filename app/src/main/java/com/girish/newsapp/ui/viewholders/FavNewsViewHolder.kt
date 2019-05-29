package com.girish.newsapp.ui.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.girish.newsapp.domain.model.NewsArticle
import kotlinx.android.synthetic.main.favnewslist_item.view.*
import kotlinx.android.synthetic.main.newslist_item.view.*

/**
 * Created by Girish on 28/05/19.
 */
class FavNewsViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
    private var newsArticle: NewsArticle? = null

    fun bindView(newsDisplay: NewsArticle) {
        newsArticle = newsDisplay
        itemView.favnews_title.text = newsDisplay.title
        itemView.favnews_content.text = newsDisplay.description
    }
}