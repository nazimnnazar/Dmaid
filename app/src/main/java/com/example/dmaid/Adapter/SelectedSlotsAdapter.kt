package com.example.dmaid.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dmaid.Bookings
import com.example.dmaid.R

class SelectedSlotsAdapter (private val empList: ArrayList<Bookings>) :
    RecyclerView.Adapter<SelectedSlotsAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_schedules, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentEmp = empList[position]
        holder.tvDate.text = currentEmp.startdate
        holder.tvSize.text = currentEmp.apartmentsize
    }

    override fun getItemCount(): Int {
        return empList.size
    }

    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val tvDate : TextView = itemView.findViewById(R.id.tvDate)
        val tvSize : TextView = itemView.findViewById(R.id.tvApartmentSize)
        val tvDays : TextView = itemView.findViewById(R.id.tvDays)

        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }



}