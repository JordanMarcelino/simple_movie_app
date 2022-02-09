package com.example.tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource
    : TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShow(): List<TvShow>? = getTvShowFromCache()

    override suspend fun updateTvShow(): List<TvShow>? {
        val newTvShow = getTvShowFromAPI()
        tvShowLocalDataSource
            .clearAll()
        tvShowLocalDataSource
            .saveTvShow(newTvShow)
        tvShowCacheDataSource.saveTvShow(newTvShow)
        return newTvShow
    }

    private suspend fun getTvShowFromAPI() : List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShow()
            tvShowList = response.body()!!.TvShows
        }catch (e : Exception){
            Log.i("MyTag", e.message!!)
        }

        return tvShowList
    }

    private suspend fun getTvShowFromDB() : List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource
                .getTvShow()
        }catch (e : Exception){
            Log.i("MyTag", e.message!!)
        }

        if(tvShowList.isNotEmpty()) return tvShowList
        else{
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource
                .saveTvShow(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getTvShowFromCache() : List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShow()
        }catch (e : Exception){
            Log.i("MyTag", e.message!!)
        }

        if (tvShowList.isNotEmpty()) return tvShowList
        else{
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShow(tvShowList)
        }

        return tvShowList
    }
}