package com.example.tmdbclient.view.di.core

import com.example.tmdbclient.view.di.artist.ArtistSubComponent
import com.example.tmdbclient.view.di.movie.MovieSubComponent
import com.example.tmdbclient.view.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    RemoteDataModule::class,
    NetModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun artistSubComponent() : ArtistSubComponent.Factory
    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
}