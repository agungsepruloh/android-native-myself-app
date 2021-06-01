package com.example.myselfapp.screens.dailyactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapp.data.DailyActivity
import com.example.myselfapp.databinding.DailyActivityItemBinding

class DailyActivityAdapter :
    ListAdapter<DailyActivity, DailyActivityAdapter.ViewHolder>(DailyActivityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(private val binding: DailyActivityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DailyActivity) {
            binding.dailyActivity = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DailyActivityItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class DailyActivityDiffCallback : DiffUtil.ItemCallback<DailyActivity>() {
    override fun areItemsTheSame(oldItem: DailyActivity, newItem: DailyActivity): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: DailyActivity, newItem: DailyActivity): Boolean {
        return oldItem == newItem
    }
}