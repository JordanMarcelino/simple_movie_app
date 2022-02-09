package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist() : List<Artist>?
    suspend fun updateArtist() : List<Artist>?
}