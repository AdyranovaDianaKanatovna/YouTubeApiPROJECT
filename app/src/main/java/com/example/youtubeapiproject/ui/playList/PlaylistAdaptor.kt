package com.example.youtubeapiproject.ui.playList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapiproject.R
import com.example.youtubeapiproject.databinding.PlaylistItemBinding
import com.example.youtubeapiproject.extensions.load
import com.example.youtubeapiproject.model.Items

class PlaylistAdaptor(private var playlist: ArrayList<Items>) : RecyclerView.Adapter<PlaylistAdaptor
.PlayListViewHolder>() {
    private lateinit var onItemClickListener: ItemClickListener

    fun setListener(listener: ItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        return PlayListViewHolder(
            PlaylistItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount() = playlist.size


    inner class PlayListViewHolder(private val binding: PlaylistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(items: Items) {
            binding.ivPlaylist.load(items.snippet.thumbnails.medium.url)
            binding.tvPlaylistTitle.text = items.snippet.title
            binding.tvVideoCounter.text =
                itemView.context.getString(
                    R.string.video_series,
                    items.contentDetails.itemCount
                )
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(
                    items.id,
                    items.snippet.title,
                    items.snippet.description
                )

            }
        }
    }
}


interface ItemClickListener {
    fun onItemClick(id: String, title: String, description: String)
}