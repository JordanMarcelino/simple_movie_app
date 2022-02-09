package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtist() : List<Artist>
    suspend fun saveArtist(artist: List<Artist>)
    suspend fun clearAll()
}