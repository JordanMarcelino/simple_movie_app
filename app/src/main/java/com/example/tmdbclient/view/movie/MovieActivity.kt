package com.example.tmdbclient.view.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityMovieBinding
import com.example.tmdbclient.view.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory

    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector)
            .createMovieSubComponent()
            .inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
        initRecycler()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val update = menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.update_item -> {
                updateMovie()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecycler(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayMovie()
    }

    private fun displayMovie(){
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.getMovie()
        response.observe(this){
            adapter.setMovie(it!!)
            adapter.notifyDataSetChanged()
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun updateMovie(){
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.updateMovie()
        response.observe(this){
            adapter.setMovie(it!!)
            adapter.notifyDataSetChanged()
            binding.progressBar.visibility = View.GONE
        }
    }
}