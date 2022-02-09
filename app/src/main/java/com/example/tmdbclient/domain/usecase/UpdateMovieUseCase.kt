package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository){
    suspend fun execute() : List<Movie>? = movieRepository.updateMovie()
}