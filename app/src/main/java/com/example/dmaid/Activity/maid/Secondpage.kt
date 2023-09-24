package com.example.dmaid.Activity.maid

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dmaid.Adapter.AdminHomeAdapter
import com.example.dmaid.DateWiseBookings
import com.example.dmaid.MaidViewBookingDetails
import com.example.dmaid.R
import com.google.firebase.database.*

class Secondpage : AppCompatActivity() {



    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var empList: ArrayList<DateWiseBookings>
    private lateinit var dbRef: DatabaseReference
    private lateinit var maidid: String
    private lateinit var bookingid: String
    private lateinit var bookingdetailid: String


    private lateinit var stmaid :String
    private lateinit var stmaidid :String
    private lateinit var stmaid2 :String
    private lateinit var stmaidid2 :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondpage)

        maidid = intent.getStringExtra("maidid").toString()

        empRecyclerView = findViewById(R.id.rvEmp)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        bookingid =""
        bookingdetailid=""


        empList = arrayListOf<DateWiseBookings>()



        getTodayData()

        val maidRef1 = FirebaseDatabase.getInstance().getReference("bookingdetails")
        val maid1Ref1 = maidRef1.child(maidid)
        val maidRef2 = maid1Ref1.child(bookingid)

        maidRef2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                bookingdetailid = dataSnapshot.child("bookingdetailid").getValue(String::class.java).toString()
                bookingid =  dataSnapshot.child("bookingid").getValue(String::class.java).toString()
                maidid =  dataSnapshot.child("maidid").getValue(String::class.java).toString()




            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })


        Log.e(ContentValues.TAG,bookingdetailid)
        Log.e(ContentValues.TAG,bookingid)
        Log.e(ContentValues.TAG,maidid)

    }


    private fun getTodayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        val dbReff1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("dmaidid").equalTo(maidid)
        val dmaidid = maidid


        dbReff1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@Secondpage, MaidViewBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = " Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })











    }
}