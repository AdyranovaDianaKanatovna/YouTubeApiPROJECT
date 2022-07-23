package com.example.youtubeapiproject.remote

import com.example.youtubeapiproject.App
import com.example.youtubeapiproject.model.Playlist
import com.example.youtubeapiproject.model.PlaylistItems
import com.example.youtubeapiproject.core.Object
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapiproject.BuildConfig
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class Repository {

    private val youTubeApi = App.youTubeApi

    fun getPlaylists(): LiveData<Response<Playlist>> = liveData(Dispatchers.IO)
    {
        val response = youTubeApi.getPlaylists(
            Object.PART,
            Object.CHANNEL_ID,
            Object.MAX_RESULT,
            BuildConfig.API_KEY
        )

        emit(response)
    }

    fun getPlaylistItems(playlistId: String): LiveData<Response<PlaylistItems>> =
        liveData(Dispatchers.IO) {
            val response = youTubeApi.getPlaylistItems(
                Object.PART,
                BuildConfig.API_KEY,
                Object.MAX_RESULT,
                playlistId
            )

            emit(response)
        }
}