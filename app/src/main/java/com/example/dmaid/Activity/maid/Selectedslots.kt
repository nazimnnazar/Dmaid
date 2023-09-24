package com.example.dmaid.Activity.maid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dmaid.Adapter.SelectedSlotsAdapter
import com.example.dmaid.Bookings
import com.example.dmaid.R
import com.google.firebase.database.*

class Selectedslots : AppCompatActivity() {

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var empList: ArrayList<Bookings>
    private lateinit var dbRef: DatabaseReference
    private lateinit var maidid: String
    private lateinit var mstatus: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectedslots)

        maidid = intent.getStringExtra("maidid").toString()

        empRecyclerView = findViewById(R.id.rvEmp)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        empList = arrayListOf<Bookings>()

        getApartmentData()

    }

    private fun getApartmentData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE


        var dbRef1 = FirebaseDatabase.getInstance().getReference("bookings").orderByChild("allotedMaidId").equalTo(maidid)





        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mstatus = snapshot.child("status").getValue(String::class.java).toString()

                    empList.clear()
                    if (snapshot.exists()){
                        for (empSnap in snapshot.children){
                            val empData = empSnap.getValue(Bookings::class.java)
                            empList.add(empData!!)
                        }
                        val mAdapter = SelectedSlotsAdapter(empList)
                        empRecyclerView.adapter = mAdapter

                        mAdapter.setOnItemClickListener(object : SelectedSlotsAdapter.onItemClickListener{
                            override fun onItemClick(position: Int) {



                                val intent = Intent(this@Selectedslots, MaidViewServiceDetails::class.java)
                                intent.putExtra("startdate", empList[position].startdate)
                                intent.putExtra("apartmentsize", empList[position].apartmentsize)
                                intent.putExtra("freequency", empList[position].freequency)
                                intent.putExtra("days", empList[position].days)
                                intent.putExtra("shift", empList[position].shift)
                                intent.putExtra("uid", empList[position].uid)
                                intent.putExtra("maidid",maidid)

                                startActivity(intent)
                            }

                        })

                        empRecyclerView.visibility = View.VISIBLE
                        tvLoadingData.visibility = View.GONE
                    }

                }




            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}