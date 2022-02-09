package com.example.tmdbclient.data.repository.movie.datasourceimpl

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMovies(): List<Movie> = movieList

    override suspend fun saveMovies(movie: List<Movie>) {
        movieList.clear()
        movieList.addAll(movie)
    }
}