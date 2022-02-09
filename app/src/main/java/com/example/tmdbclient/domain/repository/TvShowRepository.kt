package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShow() : List<TvShow>?
    suspend fun updateTvShow() : List<TvShow>?
}