package com.example.myselfapp.screens.gallery

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myselfapp.R
import com.example.myselfapp.databinding.GalleryFragmentBinding
import com.example.myselfapp.screens.dailyactivity.DailyActivityAdapter

class GalleryFragment : Fragment() {
    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<GalleryFragmentBinding>(inflater,
            R.layout.gallery_fragment, container, false)
        viewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        val manager = GridLayoutManager(activity, 2)
        binding.galleryList.layoutManager = manager
        
        val adapter = GalleryAdapter()
        binding.galleryList.adapter = adapter

        viewModel.galleries.observe(viewLifecycleOwner, {
            it.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}