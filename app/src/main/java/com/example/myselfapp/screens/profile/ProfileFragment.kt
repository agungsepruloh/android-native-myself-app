package com.example.myselfapp.screens.profile

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myselfapp.R
import com.example.myselfapp.databinding.ProfileFragmentBinding


class ProfileFragment : Fragment() {
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = DataBindingUtil.inflate<ProfileFragmentBinding>(inflater,
            R.layout.profile_fragment, container, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        binding.phone.setOnClickListener {
            openCall()
        }

        binding.email.setOnClickListener {
            openMail()
        }

        binding.instagram.setOnClickListener {
            openInstagram()
        }

        binding.findMe.setOnClickListener {
            openMap()
        }

        return binding.root
    }

    private fun openCall() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+6281395280396")
        startActivity(intent)
    }

    private fun openMap() {
        val gmmIntentUri = Uri.parse("geo:-6.843447, 107.551838")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private fun openInstagram() {
        val uri = Uri.parse("https://instagram.com/agungsepruloh_/")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            intent.setPackage("com.instagram.android")
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
    }

    private fun openMail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "plain/text"
        intent.putExtra(Intent.EXTRA_EMAIL, "agungsepruloh1996@gmail.com")
        startActivity(Intent.createChooser(intent, "Send Email..."))
    }
}