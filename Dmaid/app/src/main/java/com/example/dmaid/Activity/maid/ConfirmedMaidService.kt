package com.example.dmaid.Activity.maid

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ConfirmedMaidService : AppCompatActivity() {

    private lateinit var week1ch: CheckBox
    private lateinit var week2ch: CheckBox
    private lateinit var week3ch: CheckBox
    private lateinit var week4ch: CheckBox
    private lateinit var update: Button

    private lateinit var maidId: String
    private lateinit var bookingdetailId: String
    private lateinit var bookingId: String
    private lateinit var maidName: String

    private lateinit var weekone: String
    private lateinit var weektwo: String
    private lateinit var weekthree: String
    private lateinit var weekfour: String

    private lateinit var weeek1: String
    private lateinit var weeek2: String
    private lateinit var weeek3: String
    private lateinit var weeek4: String

    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmed_maid_service)


        week1ch = findViewById(R.id.week1ch)
        week2ch = findViewById(R.id.week2ch)
        week3ch = findViewById(R.id.week3ch)
        week4ch = findViewById(R.id.week4ch)

        weekone = ""
        weektwo = ""
        weekthree = ""
        weekfour = ""

        update = findViewById(R.id.button)

        database = FirebaseDatabase.getInstance()

        bookingdetailId = intent.getStringExtra("bookingdetailid").toString()
        bookingId = intent.getStringExtra("bookingid").toString()
        maidName = intent.getStringExtra("maidname").toString()
        maidId = intent.getStringExtra("maidid").toString()
        weeek1 = intent.getStringExtra("week1").toString()
        weeek2 = intent.getStringExtra("week2").toString()
        weeek3 = intent.getStringExtra("week3").toString()
        weeek4 = intent.getStringExtra("week4").toString()



        val bRef = FirebaseDatabase.getInstance().getReference("bookingdetails")
        val b1Ref = bRef.child(maidId).child(bookingId)


        b1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(ds: DataSnapshot) {
                weekone = ds.child("week1").getValue(String::class.java).toString()
                weektwo = ds.child("week2").getValue(String::class.java).toString()
                weekthree = ds.child("week3").getValue(String::class.java).toString()
                weekfour = ds.child("week4").getValue(String::class.java).toString()

                //   Log.e(ContentValues.TAG, maidstatus)


            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }

        })


        Log.e(TAG,weekone)
        Log.e(TAG,weektwo)
        Log.e(TAG,weekthree)
        Log.e(TAG,weekfour)














            if (weeek1 == "Completed") {
                week1ch.isEnabled = false
                week1ch.visibility = View.INVISIBLE
            }
            if (weeek2 == "Completed") {
                week2ch.isEnabled = false
                week2ch.visibility = View.INVISIBLE
            }
            if (weeek3 == "Completed") {
                week3ch.isEnabled = false
                week3ch.visibility = View.INVISIBLE
            }
            if (weeek4 == "Completed") {
                week4ch.isEnabled = false
                week4ch.visibility = View.INVISIBLE
            }

            if (weeek1 == "Completed" && weeek2 == "Completed" && weeek3 == "Completed" && weeek4 == "Completed") {
                update.visibility = View.INVISIBLE
            }







            val bookingdetailid = maidId
            val bookingid = bookingId
            val maidid = maidId
            val status = "Confirmed"


            val hashmap: HashMap<String,Any> = HashMap()
            hashmap["bookingdetailid"] = bookingdetailid
            hashmap["bookingid"] = bookingid
            hashmap["maidid"] = maidid
            hashmap["status"] = status









        update.setOnClickListener {

            val ref = FirebaseDatabase.getInstance().reference.child("bookingdetails").child(bookingdetailid).child(bookingid)
            val updates: MutableMap<String, Any> = HashMap()

            if (week1ch.isChecked) {
                updates["week1"] = "Completed"
            }
            if (week2ch.isChecked) {
                updates["week2"] = "Completed"
            }
            if (week3ch.isChecked) {
                updates["week3"] = "Completed"
            }
            if (week4ch.isChecked) {
                updates["week4"] = "Completed"
            }

//etc
            Toast.makeText(this," updated", Toast.LENGTH_SHORT).show()

//etc
            ref.updateChildren(updates)
        }




        }
    override fun onBackPressed() {

        val intent = Intent(this, Menupage::class.java)
        startActivity(intent)
        finish()
    }



    }
