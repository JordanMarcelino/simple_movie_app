package com.example.tmdbclient.view.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetTvShowUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowUseCase


class TvShowViewModelFactory(
    private val updateTvShowUseCase: UpdateTvShowUseCase,
    private val getTvShowUseCase: GetTvShowUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(updateTvShowUseCase, getTvShowUseCase) as T
    }
}