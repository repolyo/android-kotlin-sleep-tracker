package com.example.android.trackmysleepquality.sleepdetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.trackmysleepquality.database.SleepDatabaseDao

class SleepDetailViewModelFactory(
            private val nightId: Long,
            private val sleepQuality: Int,
            private val sleepStart: Long,
            private val sleepEnd: Long,
            private val dataSource: SleepDatabaseDao,
            private val application: Application) : ViewModelProvider.Factory {

        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SleepDetailViewModel::class.java)) {
                return SleepDetailViewModel(nightId, sleepQuality, sleepStart, sleepEnd, dataSource, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }