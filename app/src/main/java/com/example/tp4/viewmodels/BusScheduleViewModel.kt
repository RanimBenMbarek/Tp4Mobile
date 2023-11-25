package com.example.tp4.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tp4.busSchedule.Dao.ScheduleDAO
import com.example.tp4.busSchedule.Schedule


class BusScheduleViewModel(private val scheduleDao: ScheduleDAO): ViewModel() {
    fun fullSchedule(): LiveData<List<Schedule>> = scheduleDao.getAll()
    fun scheduleForStopName(name: String): LiveData<List<Schedule>> = scheduleDao.getByStopName(name)
}