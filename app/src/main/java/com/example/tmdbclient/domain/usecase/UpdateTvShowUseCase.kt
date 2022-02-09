package com.example.tmdbclient.domain.usecase
import com.example.tmdbclient.data.model.tvshow.TVShow
import com.example.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute() : List<TVShow>? = tvShowRepository.updateTvShow()
}