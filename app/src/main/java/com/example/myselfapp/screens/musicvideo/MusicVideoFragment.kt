package com.example.myselfapp.screens.musicvideo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myselfapp.R
import com.example.myselfapp.databinding.MusicVideoFragmentBinding

class MusicVideoFragment : Fragment() {
    private lateinit var viewModel: MusicVideoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MusicVideoFragmentBinding>(inflater,
            R.layout.music_video_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MusicVideoViewModel::class.java)
        return binding.root
    }
}