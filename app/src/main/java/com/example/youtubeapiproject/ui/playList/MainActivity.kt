package com.example.youtubeapiproject.ui.playList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapiproject.R
import com.example.youtubeapiproject.core.BaseActivity
import com.example.youtubeapiproject.databinding.ActivityMainBinding
import com.example.youtubeapiproject.model.Items
import com.example.youtubeapiproject.ui.playlistvideos.PlaylistVideosActivity

class MainActivity : BaseActivity<ActivityMainBinding>(), ItemClickListener {
    private val viewModel by lazy { ViewModelProvider(this)[PlayListViewModel::class.java] }
    private var playlist: ArrayList<Items>? = arrayListOf()
    private val playlistAdaptor by lazy { playlist?.let { PlaylistAdaptor(it) } }
    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel.getPlaylist().observe(this) { response ->
            if (response.body() != null) {
                playlist = response.body()?.items
            }
            playlistAdaptor?.setListener(this)
            binding.rvPlaylists.adapter = playlistAdaptor
        }

    }


    override fun checkInternet() {
    }

    override fun initClickListener() {

    }

    override fun setUI() {
    }

    override fun onItemClick(id: String, title: String, description: String) {
        Intent(this, PlaylistVideosActivity::class.java).apply {
            putExtra("id", id)
            putExtra("description", description)
            putExtra("title", title)
            startActivity(this)
        }
    }
}