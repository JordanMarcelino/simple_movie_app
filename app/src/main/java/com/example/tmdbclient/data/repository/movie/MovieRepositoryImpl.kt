package com.example.tmdbclient.data.repository.movie

import android.util.Log
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovie(): List<Movie>? = getMovieFromCache()

    override suspend fun updateMovie(): List<Movie>? {
        val newMovie = getMovieFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovies(newMovie)
        movieCacheDataSource.saveMovies(newMovie)
        return newMovie
    }

    private suspend fun getMovieFromAPI() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            movieList = response.body()!!.movies
        }catch (e : Exception){
            Log.i("MyTag", e.message!!)
        }

        return movieList
    }

    private suspend fun getMovieFromDB() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = movieLocalDataSource.getMovies()
        }catch (e : Exception){
            Log.i("MyTag", e.message!!)
        }

        if(movieList.isNotEmpty()) return movieList
        else{
            movieList = getMovieFromAPI()
            movieLocalDataSource.saveMovies(movieList)
        }
        return movieList
    }

    private suspend fun getMovieFromCache() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = movieCacheDataSource.getMovies()
        }catch (e : Exception){
            Log.i("MyTag", e.message!!)
        }

        if (movieList.isNotEmpty()) return movieList
        else{
            movieList = getMovieFromDB()
            movieCacheDataSource.saveMovies(movieList)
        }

        return movieList
    }
}