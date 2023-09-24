package com.example.dmaid.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dmaid.DateWiseBookings
import com.example.dmaid.R

class AdminHomeAdapter (private val empList: ArrayList<DateWiseBookings>) :
    RecyclerView.Adapter<AdminHomeAdapter.ViewHolder>() {

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
        holder.tvDate.text = currentEmp.ddate
        holder.tvName.text = currentEmp.ddoorNo
    }

    override fun getItemCount(): Int {
        return empList.size
    }

    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val tvDate : TextView = itemView.findViewById(R.id.tvDate)
        val tvName : TextView = itemView.findViewById(R.id.tvNAme)

        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }



}