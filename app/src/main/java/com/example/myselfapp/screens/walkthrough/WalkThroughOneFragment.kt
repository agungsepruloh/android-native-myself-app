package com.example.myselfapp.screens.walkthrough

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myselfapp.R
import com.example.myselfapp.databinding.WalkThroughOneFragmentBinding

class WalkThroughOneFragment : Fragment() {
    private lateinit var viewModel: WalkThroughOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<WalkThroughOneFragmentBinding>(inflater, R.layout.walk_through_one_fragment, container, false)
        viewModel = ViewModelProvider(this).get(WalkThroughOneViewModel::class.java)

        return binding.root
    }

}