package com.example.tmdbclient.view.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityTvShowBinding
import com.example.tmdbclient.view.di.Injector
import javax.inject.Inject


class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: TvShowViewModelFactory

    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector)
            .createTvShowSubComponent()
            .inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[TvShowViewModel::class.java]
        initRecycler()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val update = menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.update_item -> {
                updateTvShow()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecycler(){
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayTvShow()
    }

    private fun displayTvShow(){
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.getTvShow()
        response.observe(this){
            adapter.setTvShow(it!!)
            adapter.notifyDataSetChanged()
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun updateTvShow(){
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.updateTvShow()
        response.observe(this){
            adapter.setTvShow(it!!)
            adapter.notifyDataSetChanged()
            binding.progressBar.visibility = View.GONE
        }
    }
}