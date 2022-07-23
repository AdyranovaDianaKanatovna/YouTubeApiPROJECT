package com.example.youtubeapiproject.model

data class PlaylistItems(
    val etag: String,
    val items: ArrayList<Items>,
    val kind: String,
    val pageInfo: PageInfo
)