package com.example.tmdbclient.view

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.view.di.Injector
import com.example.tmdbclient.view.di.artist.ArtistSubComponent
import com.example.tmdbclient.view.di.core.*
import com.example.tmdbclient.view.di.movie.MovieSubComponent
import com.example.tmdbclient.view.di.tvshow.TvShowSubComponent

class App : Application(), Injector{

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createArtistSubComponent(): ArtistSubComponent = appComponent.artistSubComponent().create()

    override fun createMovieSubComponent(): MovieSubComponent = appComponent.movieSubComponent().create()

    override fun createTvShowSubComponent(): TvShowSubComponent = appComponent.tvShowSubComponent().create()
}