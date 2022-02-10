package com.example.tmdbclient.view.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetArtistUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUseCase

class ArtistViewModelFactory(
    private val updateArtistUseCase: UpdateArtistUseCase,
    private val getArtistUseCase: GetArtistUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(updateArtistUseCase, getArtistUseCase) as T
    }
}