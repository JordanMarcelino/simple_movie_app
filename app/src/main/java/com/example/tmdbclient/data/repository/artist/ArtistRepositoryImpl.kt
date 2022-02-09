package com.example.tmdbclient.data.repository.artist

import android.util.Log
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtist(): List<Artist>? = getArtistFromCache()

    override suspend fun updateArtist(): List<Artist>? {
        val newArtist = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtist(newArtist)
        artistCacheDataSource.saveArtist(newArtist)
        return newArtist
    }

    private suspend fun getArtistFromAPI() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            val response = artistRemoteDataSource.getArtist()
            artistList = response.body()!!.artists
        }catch (e : Exception){
            Log.i("MyTag", e.message!!)
        }

        return artistList
    }

    private suspend fun getArtistFromDB() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistLocalDataSource.getArtist()
        }catch (e : Exception){
            Log.i("MyTag", e.message!!)
        }

        if(artistList.isNotEmpty()) return artistList
        else{
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtist(artistList)
        }
        return artistList
    }

    private suspend fun getArtistFromCache() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistCacheDataSource.getArtist()
        }catch (e : Exception){
            Log.i("MyTag", e.message!!)
        }

        if (artistList.isNotEmpty()) return artistList
        else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtist(artistList)
        }

        return artistList
    }
}