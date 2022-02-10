package com.example.tmdbclient.view.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>(){

    private val artistList = ArrayList<Artist>()

    fun setArtist(artist : List<Artist>){
        artistList.clear()
        artistList.addAll(artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class ArtistViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(artist : Artist){
        binding.titleTextView.text = artist.popularity.toString()
        binding.descriptionTextView.text = artist.name
        val posterUrl = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide
            .with(binding.posterImage.context)
            .load(posterUrl)
            .into(binding.posterImage)
    }
}