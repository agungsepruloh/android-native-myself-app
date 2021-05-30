package com.example.myselfapp.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {
    private val _eventDoneWalkThrough = MutableLiveData<Boolean>()
    val eventDoneWalkThrough: LiveData<Boolean>
        get() = _eventDoneWalkThrough

    init {
        _eventDoneWalkThrough.value = false
    }

    fun doneWalkThrough() {
        _eventDoneWalkThrough.value = true
    }

    fun onDoneWalkThroughComplete() {
        _eventDoneWalkThrough.value = false
    }
}