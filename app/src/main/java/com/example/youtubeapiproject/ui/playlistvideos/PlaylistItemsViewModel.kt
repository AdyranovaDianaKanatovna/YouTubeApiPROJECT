package com.example.youtubeapiproject.ui.playlistvideos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapiproject.App
import com.example.youtubeapiproject.model.PlaylistItems
import retrofit2.Response

class PlaylistItemsViewModel : ViewModel() {

    fun getPlaylistItems(playlistId: String): LiveData<Response<PlaylistItems>> {
        return App.repository.getPlaylistItems(playlistId)
    }
}