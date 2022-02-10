package com.example.tmdbclient.view.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Singleton
    @Provides
    fun providesArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource = ArtistRemoteDataSourceImpl(tmdbService, apiKey)

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource = MovieRemoteDataSourceImpl(tmdbService, apiKey)

    @Singleton
    @Provides
    fun providesTvShowRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDataSource = TvShowRemoteDataSourceImpl(tmdbService, apiKey)
}