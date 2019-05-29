package com.girish.newsapp.data.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Girish on 28/05/19.
 */
@Entity(tableName = "table_favshows")
data class FavoriteShows(
        @PrimaryKey
        val title : String,

        val description: String
)