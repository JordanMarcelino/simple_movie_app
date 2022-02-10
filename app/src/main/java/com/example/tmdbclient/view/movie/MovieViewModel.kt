package com.example.tmdbclient.view.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetMovieUseCase
import com.example.tmdbclient.domain.usecase.UpdateMovieUseCase

class MovieViewModel(
    private val updateMovieUseCase: UpdateMovieUseCase,
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    fun getMovie() = liveData{
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovie() = liveData{
        val updateMovie = updateMovieUseCase.execute()
        emit(updateMovie)
    }
}