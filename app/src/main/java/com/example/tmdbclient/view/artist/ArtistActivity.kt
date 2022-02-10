package com.example.tmdbclient.view.artist

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityArtistBinding
import com.example.tmdbclient.view.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ArtistViewModelFactory

    private lateinit var adapter: ArtistAdapter
    private lateinit var viewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector)
            .createArtistSubComponent()
            .inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[ArtistViewModel::class.java]
            initRecycler()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val update = menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.update_item -> {
                updateArtist()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecycler(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayArtist()
    }

    private fun displayArtist(){
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.getArtist()
        response.observe(this){
            adapter.setArtist(it!!)
            adapter.notifyDataSetChanged()
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun updateArtist(){
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.updateArtist()
        response.observe(this){
            adapter.setArtist(it!!)
            adapter.notifyDataSetChanged()
            binding.progressBar.visibility = View.GONE
        }
    }

}