package com.example.tmdbclient.view.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val basesUrl : String){

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .apply {
            addInterceptor(interceptor)
        }.build()

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(
        GsonConverterFactory.create(
            GsonBuilder()
                .create()))
        .client(client)
        .baseUrl(basesUrl)
        .build()

    @Singleton
    @Provides
    fun providesTmdbServices(retrofit: Retrofit) : TMDBService = retrofit.create(TMDBService::class.java)

}