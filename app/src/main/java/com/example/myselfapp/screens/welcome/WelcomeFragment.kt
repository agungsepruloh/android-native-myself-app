package com.example.myselfapp.screens.welcome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.myselfapp.MainActivity
import com.example.myselfapp.R
import com.example.myselfapp.databinding.WelcomeFragmentBinding
import com.example.myselfapp.screens.walkthrough.WalkThroughAdapter
import me.relex.circleindicator.CircleIndicator3


class WelcomeFragment : Fragment() {
    private lateinit var viewModel: WelcomeViewModel
    private lateinit var viewPager: ViewPager2
    lateinit var indicator: CircleIndicator3
    lateinit var walkThroughAdapter: WalkThroughAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        hideActionBar()
        val binding = DataBindingUtil.inflate<WelcomeFragmentBinding>(inflater,
            R.layout.welcome_fragment, container, false)

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.viewModel = viewModel
        setupViewPager(binding)

        viewModel.eventDoneWalkThrough.observe(viewLifecycleOwner, { isDone ->
            if (isDone) {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        })

        return binding.root
    }

    private fun setupViewPager(binding: WelcomeFragmentBinding) {
        viewPager = binding.viewPager
        indicator = binding.indicator
        walkThroughAdapter = WalkThroughAdapter(this)

        viewPager.adapter = walkThroughAdapter
        indicator.setViewPager(viewPager)
        walkThroughAdapter.registerAdapterDataObserver(indicator.adapterDataObserver)
    }

    private fun hideActionBar() {
        val supportActionBar: ActionBar? = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.hide()
    }
}