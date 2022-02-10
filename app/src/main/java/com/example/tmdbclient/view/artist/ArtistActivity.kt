package com.example.tmdbclient.view.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityArtistBinding
import com.example.tmdbclient.view.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}