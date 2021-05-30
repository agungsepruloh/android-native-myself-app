package com.example.myselfapp.screens.walkthrough

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myselfapp.screens.welcome.WelcomeFragment

class WalkThroughAdapter(fm: Fragment) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WalkThroughOneFragment()
            1 -> WalkThroughTwoFragment()
            else -> WalkThroughThreeFragment()
        }
    }
}