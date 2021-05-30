package com.example.myselfapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myselfapp.databinding.DailyActivityFragmentBinding

class DailyActivityFragment : Fragment() {
    private lateinit var viewModel: DailyActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<DailyActivityFragmentBinding>(inflater,
            R.layout.daily_activity_fragment, container, false)
        viewModel = ViewModelProvider(this).get(DailyActivityViewModel::class.java)
        return binding.root
    }
}