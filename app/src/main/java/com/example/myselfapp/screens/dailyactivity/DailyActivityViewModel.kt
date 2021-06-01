package com.example.myselfapp.screens.dailyactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myselfapp.data.DailyActivity

class DailyActivityViewModel : ViewModel() {
    private val _dailyActivities = MutableLiveData<List<DailyActivity>>()
    val dailyActivities: LiveData<List<DailyActivity>>
        get() = _dailyActivities

    init {
        _dailyActivities.value = listOf(
            DailyActivity(name = "Learning", image = "learning"),
            DailyActivity(name = "Coding", image = "coding"),
            DailyActivity(name = "Sleeping", image = "sleeping"),
        )
    }
}