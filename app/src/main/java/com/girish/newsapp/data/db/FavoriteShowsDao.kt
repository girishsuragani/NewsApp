package com.girish.newsapp.data.db

import android.arch.persistence.room.*
import com.girish.newsapp.utils.Constants
import io.reactivex.Single

/**
 * Created by Girish on 28/05/19.
 */
@Dao
interface FavoriteShowsDao {
    @Query("SELECT * FROM "+ Constants.FAVNEWS_TABLE)
    fun getallFavouriteShows() : Single<List<FavoriteShows>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoriteShow: FavoriteShows)

    @Delete
    fun remove(favoriteShow: FavoriteShows)

    @Query("DELETE FROM "+ Constants.FAVNEWS_TABLE )
    fun clearFavs()


}
