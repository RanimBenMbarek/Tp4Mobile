package com.example.tp4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp4.busSchedule.BusScheduleApplication
import com.example.tp4.viewmodels.BusScheduleViewModel
import com.example.tp4.databinding.DetailsActivityBinding
import com.example.tp4.viewmodels.BusScheduleViewModelFactory

class DetailsActivity : ComponentActivity() {
    private lateinit var binding: DetailsActivityBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var busStopAdapter: BusStopAdapter
    private val busScheduleViewModel : BusScheduleViewModel by viewModels() {
        BusScheduleViewModelFactory((application as BusScheduleApplication).database.getScheduleDao())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        val stopName = intent.getStringExtra("stopName")

        binding = DetailsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView = binding.recyclerViewDetails

        recyclerView.layoutManager = LinearLayoutManager(this)

        busStopAdapter = BusStopAdapter(emptyList()) { schedule ->

            println()
        }
        recyclerView.adapter = busStopAdapter
        busScheduleViewModel.scheduleForStopName(stopName!!).observe(this) {
            busStopAdapter.updateList(it)
        }

    }
}