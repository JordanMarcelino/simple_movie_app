package com.example.tmdbclient.view.di.core

import android.content.Context
import com.example.tmdbclient.view.di.artist.ArtistSubComponent
import com.example.tmdbclient.view.di.movie.MovieSubComponent
import com.example.tmdbclient.view.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ArtistSubComponent::class, MovieSubComponent::class, TvShowSubComponent::class])
class AppModule(private val context: Context){

    @Singleton
    @Provides
    fun providesApplicationContext() : Context = context.applicationContext
}