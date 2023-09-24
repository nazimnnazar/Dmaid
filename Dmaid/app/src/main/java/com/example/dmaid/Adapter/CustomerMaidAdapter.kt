package com.example.dmaid.Adapter

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dmaid.Bookings
import com.example.dmaid.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CustomerMaidAdapter(private val empList: ArrayList<Bookings>) :
    RecyclerView.Adapter<CustomerMaidAdapter.ViewHolder>() {

    private lateinit var name: String

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.booking_maid_item, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentEmp = empList[position]


        name = " "




        val uid = currentEmp.uid


        val bookingsRef = FirebaseDatabase.getInstance().getReference("users")
        val bookings1Ref = bookingsRef.child(uid.toString())
        val zone1NameRef = bookings1Ref.child("firstname")


        zone1NameRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                name = dataSnapshot.getValue(String::class.java).toString()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })

        holder.tvEmpName.text = name.toString()



    }

    override fun getItemCount(): Int {
        return empList.size
    }

    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val tvEmpName : TextView = itemView.findViewById(R.id.tvEmpName)

        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }



}