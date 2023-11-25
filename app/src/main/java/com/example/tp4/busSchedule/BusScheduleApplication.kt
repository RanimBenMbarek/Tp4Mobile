package com.example.tp4.busSchedule

import android.app.Application

class BusScheduleApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this) }
}