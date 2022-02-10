package com.example.tmdbclient.view.di.core

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.dao.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(context : Context) : TMDBDatabase = Room.databaseBuilder(
        context.applicationContext,
        TMDBDatabase::class.java,
        "tmdbClient"
    ).build()

    @Singleton
    @Provides
    fun providesMovieDao(tmdbDatabase: TMDBDatabase) = tmdbDatabase.movieDao()

    @Singleton
    @Provides
    fun providesArtistDao(tmdbDatabase: TMDBDatabase) = tmdbDatabase.artistDao()

    @Singleton
    @Provides
    fun providesTvShowDao(tmdbDatabase: TMDBDatabase) = tmdbDatabase.tvShowDao()

}