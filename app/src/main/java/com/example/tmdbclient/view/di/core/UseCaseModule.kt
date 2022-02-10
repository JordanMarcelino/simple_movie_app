package com.example.tmdbclient.view.di.core

import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import com.example.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetArtistUseCase(artistRepository: ArtistRepository) = GetArtistUseCase(artistRepository)

    @Provides
    fun providesUpdateArtistUseCase(artistRepository: ArtistRepository) = UpdateArtistUseCase(artistRepository)

    @Provides
    fun providesGetMovieUseCase(movieRepository: MovieRepository) = GetMovieUseCase(movieRepository)

    @Provides
    fun providesUpdateMovieUseCase(movieRepository: MovieRepository) = UpdateMovieUseCase(movieRepository)

    @Provides
    fun providesGetTvShowUseCase(tvShowRepository: TvShowRepository) = GetTvShowUseCase(tvShowRepository)

    @Provides
    fun providesUpdateTvShowUseCase(tvShowRepository: TvShowRepository) = UpdateTvShowUseCase(tvShowRepository)
}