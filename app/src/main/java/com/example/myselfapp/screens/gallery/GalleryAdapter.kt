package com.example.myselfapp.screens.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapp.data.Gallery
import com.example.myselfapp.databinding.GalleryItemBinding

class GalleryAdapter :
    ListAdapter<Gallery, GalleryAdapter.ViewHolder>(GalleryDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(private val binding: GalleryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Gallery) {
            binding.gallery = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GalleryItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class GalleryDiffCallback : DiffUtil.ItemCallback<Gallery>() {
    override fun areItemsTheSame(oldItem: Gallery, newItem: Gallery): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: Gallery, newItem: Gallery): Boolean {
        return oldItem == newItem
    }
}