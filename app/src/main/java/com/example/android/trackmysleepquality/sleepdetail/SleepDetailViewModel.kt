package com.example.android.trackmysleepquality.sleepdetail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import kotlinx.coroutines.*

class SleepDetailViewModel(
        val nightId: Long,
        val sleepQuality: Int,
        val sleepStart: Long,
        val sleepEnd: Long,
        val database: SleepDatabaseDao,
        application: Application) : ViewModel() {
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val sleepQualityText: String = convertNumericQualityToString(sleepQuality, application.resources)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}