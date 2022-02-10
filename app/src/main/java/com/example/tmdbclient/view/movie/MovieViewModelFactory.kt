package com.example.tmdbclient.view.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetMovieUseCase
import com.example.tmdbclient.domain.usecase.UpdateMovieUseCase

class MovieViewModelFactory(
    private val updateMovieUseCase: UpdateMovieUseCase,
    private val getMovieUseCase: GetMovieUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(updateMovieUseCase, getMovieUseCase) as T
    }
}