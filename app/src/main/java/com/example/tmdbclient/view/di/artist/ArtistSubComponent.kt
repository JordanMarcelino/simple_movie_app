package com.example.tmdbclient.view.di.artist

import com.example.tmdbclient.view.artist.ArtistActivity
import dagger.Provides
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : ArtistSubComponent
    }
}