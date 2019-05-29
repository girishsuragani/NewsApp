package com.girish.newsapp.data.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.girish.newsapp.utils.Constants

/**
 * Created by Girish on 28/05/19.
 */
@Entity(tableName = Constants.FAVNEWS_TABLE)
data class FavoriteShows(
        @PrimaryKey
        val title : String,

        val description: String
)