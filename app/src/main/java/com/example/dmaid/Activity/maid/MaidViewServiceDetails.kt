package com.example.dmaid.Activity.maid

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.BookingDetails
import com.example.dmaid.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MaidViewServiceDetails : AppCompatActivity() {

    private lateinit var tvdate: TextView
    private lateinit var tvsize: TextView
    private lateinit var tvdays: TextView
    private lateinit var tvShift: TextView

    private lateinit var bookingId: String
    private lateinit var maidId: String
    private lateinit var maidfirstname: String
    private lateinit var maidlastname: String
    private lateinit var maidnames: String
    private lateinit var maidstatus: String

    private lateinit var btnConfirm: Button
    private lateinit var btnCancel: Button
    private lateinit var btnUpdate: Button


    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maid_view_service_details)

        maidId = intent.getStringExtra("maidid").toString()

        database = FirebaseDatabase.getInstance()

        val maidRef = FirebaseDatabase.getInstance().getReference("maids")
        val maid1Ref = maidRef.child(maidId)

        maid1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                maidfirstname =
                    dataSnapshot.child("firstname").getValue(String::class.java).toString()
                maidlastname =
                    dataSnapshot.child("lastname").getValue(String::class.java).toString()

                maidnames = "$maidfirstname$maidlastname"

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })

        initView()
        setValuesToViews()
        Log.e(TAG,maidId)





            val bRef = FirebaseDatabase.getInstance().getReference("bookingdetails")
            val b1Ref = bRef.child(maidId).child(bookingId)


            b1Ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(ds: DataSnapshot) {
                    maidstatus = ds.child("status").getValue(String::class.java).toString()

                    Log.e(ContentValues.TAG, maidstatus)
                    if (maidstatus == "Confirmed") {

                        btnUpdate.setOnClickListener {


                            val intent =
                                Intent(
                                    this@MaidViewServiceDetails,
                                    ConfirmedMaidService::class.java
                                )
                            intent.putExtra("bookingid",bookingId)
                            intent.putExtra("maidid", maidId)
                            startActivity(intent)
                        }
                    }else{
                        btnConfirm.visibility = View.VISIBLE
                    }

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                }

            })




            btnConfirm.setOnClickListener {

            val bookingdetailid = maidId
            val bookingid = bookingId
            val maidname = maidnames
            val maidid = maidId
            val status = "Confirmed"
            val week1 = ""
            val week2 = ""
            val week3 = ""
            val week4 = ""



            val databaseRef = database.reference.child("bookingdetails")
                .child(bookingdetailid).child(bookingId)
            val bookingdetails: BookingDetails = BookingDetails(
                bookingdetailid, bookingid, maidname, maidid, status , week1, week2, week3, week4
            )

            databaseRef.setValue(bookingdetails).addOnCompleteListener {
                Log.e(TAG,bookingdetailid)
                Log.e(TAG,bookingId)
                if (it.isSuccessful) {
                    Toast.makeText(
                        this,
                        "Confirmed",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this, ConfirmedMaidService::class.java)
                    intent.putExtra("bookingdetailid",maidId)
                    intent.putExtra("bookingid",bookingId)
                    intent.putExtra("maidname",maidnames)
                    intent.putExtra("maidid",maidId)
                    intent.putExtra("status",status)
                    intent.putExtra("week1",week1)
                    intent.putExtra("week2",week2)
                    intent.putExtra("week3",week3)
                    intent.putExtra("week4",week4)
                    startActivity(intent)
                } else {

                    Toast.makeText(
                        this,
                        it.exception.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

        }



    private fun setValuesToViews() {
        tvdate.text = intent.getStringExtra("startdate")
        tvsize.text = intent.getStringExtra("apartmentsize")
        tvdays.text = intent.getStringExtra("days")
        tvShift.text = intent.getStringExtra("shift")
        bookingId = intent.getStringExtra("uid").toString()
    }

    private fun initView() {
        tvdate = findViewById(R.id.startdatetv)
        tvsize = findViewById(R.id.sizetv)
        tvdays = findViewById(R.id.daystv)
        tvShift = findViewById(R.id.shifttv)

        btnConfirm = findViewById(R.id.confirmBTn)
        btnUpdate = findViewById(R.id.updateBtn)
    }
}