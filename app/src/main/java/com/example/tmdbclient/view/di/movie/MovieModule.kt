package com.example.tmdbclient.view.di.movie

import com.example.tmdbclient.domain.usecase.GetMovieUseCase
import com.example.tmdbclient.domain.usecase.UpdateMovieUseCase
import com.example.tmdbclient.view.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ) : MovieViewModelFactory = MovieViewModelFactory(updateMovieUseCase, getMovieUseCase)
}