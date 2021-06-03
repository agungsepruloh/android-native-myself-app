package com.example.myselfapp.screens.musicvideo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myselfapp.data.Music

class MusicVideoViewModel : ViewModel() {
    private val _musics = MutableLiveData<List<Music>>()
    val musics: LiveData<List<Music>>
        get() = _musics

    init {
        _musics.value = listOf(
            Music(artist = "Billie Eilish", title = "Bad Guy", image = "gallery1"),
            Music(artist = "Billie Eilish", title = "Bury a Friend", image = "gallery2"),
            Music(artist = "Billie Eilish", title = "Copycat", image = "gallery6"),
            Music(artist = "Billie Eilish", title = "Ilomilo", image = "gallery4"),
            Music(artist = "Hailee Steinfeld", title = "Love My Self", image = "gallery3"),
            Music(artist = "Zara Larsson", title = "Lush Life", image = "gallery5"),
        )
    }
}