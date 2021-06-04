package com.example.myselfapp.screens.musicvideo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapp.data.Music
import com.example.myselfapp.data.Video
import com.example.myselfapp.databinding.HeaderBinding
import com.example.myselfapp.databinding.MusicItemBinding
import com.example.myselfapp.databinding.VideoItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val ITEM_VIEW_TYPE_HEADER = 0
private const val ITEM_VIEW_TYPE_MUSIC = 1
private const val ITEM_VIEW_TYPE_VIDEO = 2

class MusicVideoAdapter :
    ListAdapter<DataItem, RecyclerView.ViewHolder>(MusicDiffCallback()) {
    private val adapterScope = CoroutineScope(Dispatchers.Default)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_MUSIC -> ViewHolder.from(parent)
            ITEM_VIEW_TYPE_VIDEO -> VideoViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.MusicItem -> ITEM_VIEW_TYPE_MUSIC
            is DataItem.VideoItem -> ITEM_VIEW_TYPE_VIDEO
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ViewHolder -> {
                val musicItem = getItem(position) as DataItem.MusicItem
                holder.bind(musicItem.music)
            }
            is TextViewHolder -> {
                val headerItem = getItem(position) as DataItem.Header
                holder.bind(headerItem.header)
            }
            is VideoViewHolder -> {
                val headerItem = getItem(position) as DataItem.VideoItem
                holder.bind(headerItem.video)
            }
        }
    }

    fun addHeaderAndSubmitListMusic(list: List<Music>?) {
        val title: String = "Musics"
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(DataItem.Header(title))
                else -> listOf(DataItem.Header(title)) + list.map{ DataItem.MusicItem(it) }
            }

            Log.d("SubmitListVideo", (currentList + items).toString())
            withContext(Dispatchers.Main) {
                submitList(currentList + items)
            }
        }
    }

    fun addHeaderAndSubmitListVideo(list: List<Video>?) {
        val title: String = "Videos"
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(DataItem.Header(title))
                else -> listOf(DataItem.Header(title)) + list.map{ DataItem.VideoItem(it) }
            }

            Log.d("SubmitListVideo", (currentList + items).toString())
            withContext(Dispatchers.Main) {
                submitList(currentList + items)
            }
        }
    }

    class ViewHolder private constructor(private val binding: MusicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Music) {
            binding.music = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MusicItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class VideoViewHolder private constructor(private val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Video) {
            binding.video = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): VideoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = VideoItemBinding.inflate(layoutInflater, parent, false)
                return VideoViewHolder(binding)
            }
        }
    }



    class TextViewHolder private constructor(private val binding: HeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.header = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HeaderBinding.inflate(layoutInflater, parent, false)
                return TextViewHolder(binding)
            }
        }
    }
}

class MusicDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}

sealed class DataItem {
    data class MusicItem(val music: Music): DataItem() {
        override val id = music.id
    }
    data class VideoItem(val video: Video): DataItem() {
        override val id = video.id
    }
    data class Header(val header: String): DataItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}
