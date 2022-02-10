package com.example.tmdbclient.view.di

import com.example.tmdbclient.view.di.artist.ArtistSubComponent
import com.example.tmdbclient.view.di.movie.MovieSubComponent
import com.example.tmdbclient.view.di.tvshow.TvShowSubComponent

interface Injector {

    fun createArtistSubComponent() : ArtistSubComponent
    fun createMovieSubComponent() : MovieSubComponent
    fun createTvShowSubComponent() : TvShowSubComponent
}