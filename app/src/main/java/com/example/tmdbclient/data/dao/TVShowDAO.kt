package com.example.tmdbclient.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.tvshow.TVShow

@Dao
interface TVShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShow: List<TVShow>)

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM popular_tvshow")
    suspend fun updateTvShow() : List<TVShow>
}