package com.girish.newsapp.data.db

import android.arch.persistence.room.*
import io.reactivex.Single

/**
 * Created by Girish on 28/05/19.
 */
@Dao
interface FavoriteShowsDao {
    @Query("SELECT * FROM table_favshows")
    fun getallFavouriteShows() : Single<List<FavoriteShows>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoriteShow: FavoriteShows)

    @Delete
    fun remove(favoriteShow: FavoriteShows)

    @Query("DELETE FROM table_favshows" )
    fun clearFavs()


}
