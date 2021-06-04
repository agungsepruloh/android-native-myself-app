package com.example.myselfapp.screens.musicvideo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        val adapter = MusicVideoAdapter()
        binding.musicVideoList.adapter = adapter

        viewModel.musics.observe(viewLifecycleOwner, {
            it.let {
                adapter.addHeaderAndSubmitListMusic(it)
            }
        })

        viewModel.videos.observe(viewLifecycleOwner, {
            it.let {
                adapter.addHeaderAndSubmitListVideo(it)
            }
        })

        return binding.root
    }
}