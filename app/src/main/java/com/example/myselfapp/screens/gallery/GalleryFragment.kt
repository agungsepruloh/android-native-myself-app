package com.example.myselfapp.screens.gallery

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myselfapp.R
import com.example.myselfapp.databinding.GalleryFragmentBinding

class GalleryFragment : Fragment() {
    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<GalleryFragmentBinding>(inflater,
            R.layout.gallery_fragment, container, false)
        viewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        return binding.root
    }
}