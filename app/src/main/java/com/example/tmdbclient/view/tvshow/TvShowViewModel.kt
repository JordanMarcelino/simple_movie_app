package com.example.tmdbclient.view.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetTvShowUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val updateTvShowUseCase: UpdateTvShowUseCase,
    private val getTvShowUseCase: GetTvShowUseCase
) : ViewModel() {

    fun getTvShow() = liveData{
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData{
        val updateTvShow = updateTvShowUseCase.execute()
        emit(updateTvShow)
    }
}