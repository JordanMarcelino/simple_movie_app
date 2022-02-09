package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShow() : List<TvShow>
    suspend fun saveTvShow(tvShow: List<TvShow>)
    suspend fun clearAll()
}