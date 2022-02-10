package com.example.tmdbclient.view.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.databinding.ListItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>(){

    private val movieList = ArrayList<Movie>()

    fun setMovie(movie : List<Movie>){
        movieList.clear()
        movieList.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(movie : Movie){
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide
            .with(binding.posterImage.context)
            .load(posterUrl)
            .into(binding.posterImage)
    }
}