package com.example.tmdbclient.view.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityMovieBinding
import com.example.tmdbclient.view.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory

    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector)
            .createMovieSubComponent()
            .inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
        val response = viewModel.getMovie()
        response.observe(this){
            Log.i("MyTag", it.toString())
        }
    }
}