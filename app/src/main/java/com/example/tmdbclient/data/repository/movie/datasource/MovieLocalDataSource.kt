package com.example.tmdbclient.data.repository.movie.datasource

import com.example.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMovies() : List<Movie>
    suspend fun saveMovies(movie : List<Movie>)
    suspend fun clearAll()
}