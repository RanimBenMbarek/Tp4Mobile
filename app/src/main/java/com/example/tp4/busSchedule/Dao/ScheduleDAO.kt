package com.example.tp4.busSchedule.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.tp4.busSchedule.Schedule

@Dao
interface ScheduleDAO {
    @Query("Select * from Schedule order by Arrival_time")
    fun getAll(): LiveData<List<Schedule>>

    @Query("Select * from Schedule where Stop_name like :stopName")
    fun getByStopName(stopName: String) : LiveData<List<Schedule>>
}