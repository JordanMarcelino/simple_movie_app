package com.example.tmdbclient.view.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetArtistUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val updateArtistUseCase: UpdateArtistUseCase,
    private val getArtistUseCase: GetArtistUseCase
) : ViewModel() {

    fun getArtist() = liveData{
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData{
        val updateArtist = updateArtistUseCase.execute()
        emit(updateArtist)
    }
}