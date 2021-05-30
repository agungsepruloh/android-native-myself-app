package com.example.myselfapp.screens.walkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myselfapp.R
import com.example.myselfapp.databinding.WalkThroughThreeFragmentBinding

class WalkThroughThreeFragment : Fragment() {
    private lateinit var viewModel: WalkThroughThreeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<WalkThroughThreeFragmentBinding>(inflater, R.layout.walk_through_three_fragment, container, false)
        viewModel = ViewModelProvider(this).get(WalkThroughThreeViewModel::class.java)

        return binding.root
    }
}