package com.example.myselfapp.screens.walkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myselfapp.R
import com.example.myselfapp.databinding.WalkThroughTwoFragmentBinding

class WalkThroughTwoFragment : Fragment() {
    private lateinit var viewModel: WalkThroughTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<WalkThroughTwoFragmentBinding>(inflater, R.layout.walk_through_two_fragment, container, false)
        viewModel = ViewModelProvider(this).get(WalkThroughTwoViewModel::class.java)

        return binding.root
    }
}