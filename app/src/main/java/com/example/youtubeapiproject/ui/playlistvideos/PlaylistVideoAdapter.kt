package com.example.youtubeapiproject.ui.playlistvideos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapiproject.databinding.PlaylistVideosItemBinding
import com.example.youtubeapiproject.extensions.load
import com.example.youtubeapiproject.model.Items

class PlaylistVideosAdapter(private var videos: ArrayList<Items>) :
    RecyclerView.Adapter<PlaylistVideosAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            PlaylistVideosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.onBind(videos[position])
    }

    override fun getItemCount() = videos.size

    class VideoViewHolder(private val binding: PlaylistVideosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(items: Items) {
            binding.ivVideo.load(items.snippet.thumbnails.medium.url)
            binding.tvVideoTitle.text = items.snippet.title
            binding.tvVideoPublishedAt.text = items.contentDetails.videoPublishedAt
        }
    }
}