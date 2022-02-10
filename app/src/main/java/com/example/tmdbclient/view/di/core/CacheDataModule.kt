package com.example.tmdbclient.view.di.core

import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesArtistCacheDataSource() : ArtistCacheDataSource = ArtistCacheDataSourceImpl()


    @Singleton
    @Provides
    fun providesMovieCacheDataSource() : MovieCacheDataSource = MovieCacheDataSourceImpl()


    @Singleton
    @Provides
    fun providesTvShowCacheDataSource() : TvShowCacheDataSource = TvShowCacheDataSourceImpl()
}