package com.example.tmdbclient.view.di.core

import com.example.tmdbclient.data.dao.ArtistDao
import com.example.tmdbclient.data.dao.MovieDAO
import com.example.tmdbclient.data.dao.TVShowDAO
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource = ArtistLocalDataSourceImpl(artistDao)


    @Singleton
    @Provides
    fun providesMovieLocalDataSource(movieDAO: MovieDAO) : MovieLocalDataSource = MovieLocalDataSourceImpl(movieDAO)


    @Singleton
    @Provides
    fun providesTvShowLocalDataSource(tvShowDAO: TVShowDAO) : TvShowLocalDataSource = TvShowLocalDataSourceImpl(tvShowDAO)
}