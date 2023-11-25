package com.example.tp4


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp4.busSchedule.Schedule
import java.text.SimpleDateFormat
import java.util.Locale



class BusStopAdapter(private var busStops: List<Schedule>, private val onItemClick: (Schedule) -> Unit) :
    RecyclerView.Adapter<BusStopAdapter.ViewHolder>() {

    fun Long.toTimeDateString(): String {
        val dateTime = java.util.Date(this)
        val format = SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.US)
        return format.format(dateTime)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stopNameTextView: TextView = itemView.findViewById(R.id.stopName)
        val arrivalTimeTextView: TextView = itemView.findViewById(R.id.arrivalTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentBusStop = busStops[position]

        holder.stopNameTextView.text = currentBusStop.stopName
        holder.arrivalTimeTextView.text = currentBusStop.arrivalTime.toLong().toTimeDateString()

        // Set click listener on the item
        holder.itemView.setOnClickListener {
            onItemClick(currentBusStop)
        }

    }
    override fun getItemCount(): Int {
        return busStops.size
    }
    fun updateList(newList: List<Schedule>) {
        busStops = newList
        notifyDataSetChanged()
    }




}