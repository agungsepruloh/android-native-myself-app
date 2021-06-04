package com.example.myselfapp.screens.musicvideo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myselfapp.data.Music
import com.example.myselfapp.data.Video

class MusicVideoViewModel : ViewModel() {
    private val _musics = MutableLiveData<List<Music>>()
    val musics: LiveData<List<Music>>
        get() = _musics

    private val _videos = MutableLiveData<List<Video>>()
    val videos: LiveData<List<Video>>
        get() = _videos

    init {
        _musics.value = listOf(
            Music(id = 0, artist = "Billie Eilish", title = "Bad Guy", image = "gallery1"),
            Music(id = 1, artist = "Billie Eilish", title = "Bury a Friend", image = "gallery2"),
            Music(id = 2, artist = "Billie Eilish", title = "Copycat", image = "gallery6"),
            Music(id = 3, artist = "Billie Eilish", title = "Ilomilo", image = "gallery4"),
            Music(id = 4, artist = "Hailee Steinfeld", title = "Love My Self", image = "gallery3"),
            Music(id = 5, artist = "Zara Larsson", title = "Lush Life", image = "gallery5"),
        )

        _videos.value = listOf(
            Video(id = 11, path = "nature", title = "Nature")
        )
    }
}