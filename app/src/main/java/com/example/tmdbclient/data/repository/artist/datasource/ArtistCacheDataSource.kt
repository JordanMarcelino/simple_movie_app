package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtist() : List<Artist>
    suspend fun saveArtist(artist : List<Artist>)
}