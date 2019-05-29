package com.girish.newsapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.girish.newsapp.R
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.domain.model.NewsList
import com.girish.newsapp.ui.viewholders.NewsListViewHolder

/**
 * Created by Girish on 27/05/19.
 */
class NewsListAdapter (var newsList: List<NewsArticle> = ArrayList(),
                       private val onItemClickListener:
                       ((position: Int, newsArticle: NewsArticle?) -> Unit)?) :
        RecyclerView.Adapter<NewsListViewHolder> (){


    fun setNews(newsList: List<NewsArticle>) {
        this.newsList = newsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newslist_item, parent, false)
        return NewsListViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int  = newsList.size

    override fun onBindViewHolder(viewHolder: NewsListViewHolder, position: Int) {
        viewHolder.bindView(newsList[position])
    }

}
