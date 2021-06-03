package com.example.myselfapp.screens.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myselfapp.data.Gallery

class GalleryViewModel : ViewModel() {
    private val _galleries = MutableLiveData<List<Gallery>>()
    val galleries: LiveData<List<Gallery>>
        get() = _galleries

    init {
        _galleries.value = listOf(
            Gallery(image = "gallery1"),
            Gallery(image = "gallery2"),
            Gallery(image = "gallery3"),
            Gallery(image = "gallery4"),
            Gallery(image = "gallery5"),
            Gallery(image = "gallery6"),
        )
    }
}