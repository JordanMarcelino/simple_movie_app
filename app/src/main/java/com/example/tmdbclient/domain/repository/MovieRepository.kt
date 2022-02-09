package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovie() : List<Movie>?
    suspend fun updateMovie() : List<Movie>?
}