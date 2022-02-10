package com.example.tmdbclient.view.di.tvshow

import com.example.tmdbclient.domain.usecase.GetTvShowUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowUseCase
import com.example.tmdbclient.view.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun providesTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ) : TvShowViewModelFactory = TvShowViewModelFactory(updateTvShowUseCase, getTvShowUseCase)
}