package com.example.tmdbclient.data.repository.movie.datasourceimpl

import com.example.tmdbclient.data.dao.MovieDAO
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(
    private val movieDAO: MovieDAO
) : MovieLocalDataSource {

    override suspend fun getMovies(): List<Movie> = movieDAO.updateMovies()

    override suspend fun saveMovies(movie: List<Movie>){
        CoroutineScope(Dispatchers.IO).launch{
            movieDAO.saveMovies(movie)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}