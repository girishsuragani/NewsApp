package com.girish.newsapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.girish.newsapp.R
import com.girish.newsapp.domain.model.NewsArticle
import kotlinx.android.synthetic.main.favnewslist_item.view.*

/**
 * Created by Girish on 28/05/19.
 */
class FavNewsAdapter() :
        RecyclerView.Adapter<FavNewsAdapter.FavNewsViewHolder> (){


    private val newsList = arrayListOf<NewsArticle>()


    fun setData(newsArticleList: List<NewsArticle>) {
        this.newsList.clear()
        this.newsList.addAll(newsArticleList)
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FavNewsAdapter.FavNewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favnewslist_item, parent, false)
        return FavNewsViewHolder(view)
    }

    override fun getItemCount(): Int  = this.newsList.size

    override fun onBindViewHolder(viewHolder: FavNewsViewHolder, position: Int) {
        viewHolder.setData(newsList[position])
    }

    inner class FavNewsViewHolder(
            private val newsBookmarkListItemView: View
    ) : RecyclerView.ViewHolder(newsBookmarkListItemView) {

        fun setData(newsArticle: NewsArticle?) {
            newsBookmarkListItemView.favnews_title.text = newsArticle?.title
            newsBookmarkListItemView.favnews_content.text = newsArticle?.description
        }
    }

}
