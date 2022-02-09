package com.example.tmdbclient.data.repository.artist.datasourceimpl

import com.example.tmdbclient.data.dao.ArtistDao
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
) : ArtistLocalDataSource {

    override suspend fun getArtist(): List<Artist> = artistDao.updateArtist()

    override suspend fun saveArtist(artist: List<Artist>){
        CoroutineScope(Dispatchers.IO).launch{
            artistDao.saveArtist(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}