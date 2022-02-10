package com.example.tmdbclient.view.di.artist

import com.example.tmdbclient.domain.usecase.GetArtistUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.example.tmdbclient.view.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providesArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ) : ArtistViewModelFactory = ArtistViewModelFactory(updateArtistUseCase, getArtistUseCase)
}