package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.tvshow.TVShow

interface TvShowRepository {
    suspend fun getTvShow() : List<TVShow>?
    suspend fun updateTvShow() : List<TVShow>?
}