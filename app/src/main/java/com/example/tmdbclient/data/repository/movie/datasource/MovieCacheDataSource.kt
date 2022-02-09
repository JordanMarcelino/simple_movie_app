package com.example.tmdbclient.data.repository.movie.datasource

import com.example.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMovies() : List<Movie>
    suspend fun saveMovies(movie : List<Movie>)
}