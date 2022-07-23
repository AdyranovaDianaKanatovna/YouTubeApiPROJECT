package com.example.youtubeapiproject

import android.app.Application
import com.example.youtubeapiproject.remote.Repository
import com.example.youtubeapiproject.remote.RetroFitClient

class App : Application() {
    companion object {
        val youTubeApi = RetroFitClient.provideRetrofit()
        val repository = Repository()
    }
}