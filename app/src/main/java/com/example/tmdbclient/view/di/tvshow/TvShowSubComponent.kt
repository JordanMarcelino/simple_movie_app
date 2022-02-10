package com.example.tmdbclient.view.di.tvshow

import com.example.tmdbclient.view.artist.ArtistActivity
import com.example.tmdbclient.view.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : TvShowSubComponent
    }
}