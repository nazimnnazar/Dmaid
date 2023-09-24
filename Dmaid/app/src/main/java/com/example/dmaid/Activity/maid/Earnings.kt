package com.example.dmaid.Activity.maid

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.AdminHome
import com.example.dmaid.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.*

class Earnings : AppCompatActivity() {

    private lateinit var directEarnings: TextView
    //private lateinit var category: TextView
    private lateinit var review: TextView
    private lateinit var grooming: TextView
    private lateinit var attendence: TextView
    private lateinit var special: TextView
    private lateinit var total: TextView
    private lateinit var dateToStr: String
    private lateinit var date :  String
    private lateinit var maidid: String

    var directm : Float = 0.0f
    var reviewm : Float = 0.0f
    var groomm : Float = 0.0f
    var specialm : Float = 0.0f
    //var categorym = 0
    var attendm : Float = 0.0f
    var sum = 0
    var sum1 : Float = 0.0f
   // var sum2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_earnings)

        directEarnings = findViewById(R.id.direct_er)
        //category = findViewById(R.id.category_er)
        review = findViewById(R.id.review_er)
        grooming = findViewById(R.id.grooming_er)
        attendence = findViewById(R.id.attendance_er)
        special = findViewById(R.id.special_er)
        total = findViewById(R.id.total_er)
        maidid = intent.getStringExtra("maidid").toString()

        val today = Date()
        val outformat = SimpleDateFormat("yyyy-MM")
        dateToStr= outformat.format(today)
        val date1 = SimpleDateFormat("dd")
        date = date1.format(today)

        val bookingsRef1 = FirebaseDatabase.getInstance().getReference("maidearnings")
        val bookings1Ref1 = bookingsRef1.child(dateToStr).child("Attendance_incentive").child(maidid)
        bookings1Ref1.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.child("Attendance_incentive").exists())
                {
                    attendence.text = snapshot.child("Attendance_incentive").getValue(Float::class.java).toString()
                }
                else{
                    attendence.text = 0.toString()
                }

            }



            override fun onCancelled(error: DatabaseError) {


            }
        })
        val bookings1Ref2 = bookingsRef1.child(dateToStr).child(maidid)
        bookings1Ref2.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.child("special_incentive").exists())
                {
                    special.text = snapshot.child("special_incentive").getValue(Float::class.java).toString()
                }
                else{
                    special.text = 0.toString()
                }

            }


            override fun onCancelled(error: DatabaseError) {

            }
        })


        val bookingsRef = FirebaseDatabase.getInstance().getReference("maidearnings")
        val bookings1Ref = bookingsRef.child(dateToStr).child(date).child(maidid)

        bookings1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                /*if (dataSnapshot.child("category_incentive").exists())
                    {
                        category.text = dataSnapshot.child("category_incentive").getValue(Long::class.java).toString()
                    }
                    else{
                    category.text = 0.toString()
                }*/
                if (dataSnapshot.child("direct_earnings").exists())
                {
                    directEarnings.text = dataSnapshot.child("direct_earnings").getValue(Float::class.java).toString()
                }
                else{
                    directEarnings.text = 0.toString()
                }
                if (dataSnapshot.child("Cleaning_incentive").exists())
                {
                    review.text = dataSnapshot.child("Cleaning_incentive").getValue(Float::class.java).toString()
                }
                else{
                    review.text = 0.toString()
                }
                if (dataSnapshot.child("Grooming_incentive").exists())
                {
                    grooming.text = dataSnapshot.child("Grooming_incentive").getValue(Float::class.java).toString()
                }
                else{
                    grooming.text = 0.toString()
                }


                    try {
                        directm = directEarnings.text.toString().toFloat()
                        reviewm = review.text.toString().toFloat()
                        groomm = grooming.text.toString().toFloat()
                        specialm = special.text.toString().toFloat()
                        //categorym = category.text.toString().toInt()
                        attendm = attendence.text.toString().toFloat()
                        sum1 = directm.toFloat() + specialm /*+ categorym */+ attendm+ reviewm + groomm
                      /*  sum2 =
                        sum = sum1 + sum2*/
                        total.text = sum1.toString()
                    }catch (e: NumberFormatException)
                    {
                        e.printStackTrace()
                    }







            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })



    }
    override fun onBackPressed() {
        super.onBackPressed()
    }


}