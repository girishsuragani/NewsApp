package com.girish.newsapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.girish.newsapp.R
import com.girish.newsapp.domain.model.NewsArticle
import kotlinx.android.synthetic.main.newslist_item.view.*

/**
 * Created by Girish on 27/05/19.
 */
class NewsListAdapter ( private val onItemClickListener:
                       ((position: Int, newsArticle: NewsArticle?) -> Unit?)) :
        RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder> (){

    private val newsList = arrayListOf<NewsArticle>()

    fun setData(newsArticleList: List<NewsArticle>) {
        this.newsList.clear()
        this.newsList.addAll(newsArticleList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newslist_item, parent, false)
        return NewsListViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int  = this.newsList.size

    override fun onBindViewHolder(viewHolder: NewsListViewHolder, position: Int) {
        viewHolder.setData(newsList[position])
    }


    inner class NewsListViewHolder(
            private val newsListItemView: View,
            private val onItemClickListener: ((position: Int, newsArticle: NewsArticle?) -> Unit?)
    ) : RecyclerView.ViewHolder(newsListItemView) {

        private var newsArticle: NewsArticle? = null

        init {
            newsListItemView.favbutton.setOnClickListener {
                onItemClickListener.invoke(adapterPosition, newsArticle)
            }
        }

        fun setData(newsArticle: NewsArticle?) {
            this.newsArticle = newsArticle
            newsListItemView.news_title.text = newsArticle?.title
            newsListItemView.news_content.text = newsArticle?.description
        }
    }

}
