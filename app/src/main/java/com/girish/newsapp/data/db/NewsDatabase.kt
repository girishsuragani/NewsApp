package com.girish.newsapp.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.girish.newsapp.utils.Constants
import javax.inject.Inject

/**
 * Created by Girish on 28/05/19.
 */
@Database(entities = arrayOf(FavoriteShows::class), version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun favoriteShowsDao(): FavoriteShowsDao

    companion object {
        val DATABASE_NAME = Constants.DATABASE_NAME
    }
}
