package com.example.tmdbclient.data.repository.tvshow.datasourceimpl

import com.example.tmdbclient.data.dao.TVShowDAO
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(
    private val tvShowDao: TVShowDAO
) : TvShowLocalDataSource {

    override suspend fun getTvShow(): List<TvShow> = tvShowDao.updateTvShow()

    override suspend fun saveTvShow(tvShow: List<TvShow>){
        CoroutineScope(Dispatchers.IO).launch{
            tvShowDao.saveTvShow(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShow()
        }
    }
}