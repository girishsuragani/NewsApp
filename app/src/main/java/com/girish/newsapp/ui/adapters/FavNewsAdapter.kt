package com.girish.newsapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.girish.newsapp.R
import com.girish.newsapp.domain.model.NewsArticle
import com.girish.newsapp.ui.viewholders.FavNewsViewHolder
import com.girish.newsapp.ui.viewholders.NewsListViewHolder

/**
 * Created by Girish on 28/05/19.
 */
class FavNewsAdapter(var newsList: List<NewsArticle> = ArrayList()) :
        RecyclerView.Adapter<FavNewsViewHolder> (){


    fun setNews(newsList: List<NewsArticle>) {
        this.newsList = newsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FavNewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favnewslist_item, parent, false)
        return FavNewsViewHolder(view)
    }

    override fun getItemCount(): Int  = newsList.size

    override fun onBindViewHolder(viewHolder: FavNewsViewHolder, position: Int) {
        viewHolder.bindView(newsList[position])
    }

}
