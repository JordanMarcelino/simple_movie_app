package com.example.tmdbclient.view.di.movie

import com.example.tmdbclient.view.artist.ArtistActivity
import com.example.tmdbclient.view.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : MovieSubComponent
    }
}