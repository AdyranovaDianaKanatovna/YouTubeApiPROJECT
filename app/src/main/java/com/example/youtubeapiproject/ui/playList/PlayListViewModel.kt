package com.example.youtubeapiproject.ui.playList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapiproject.App
import com.example.youtubeapiproject.model.Playlist
import retrofit2.Response

class PlayListViewModel: ViewModel() {

    fun getPlaylist(): LiveData<Response<Playlist>>  {
        return App.repository.getPlaylists()
    }
}