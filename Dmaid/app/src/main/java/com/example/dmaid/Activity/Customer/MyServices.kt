package com.example.dmaid.Activity.Customer

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.*
import com.example.dmaid.Activity.AdminHome
import com.example.dmaid.Activity.Home
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MyServices : AppCompatActivity() {

    private lateinit var tvStartDate: TextView
    private lateinit var tvApartmentSize: TextView
    private lateinit var tvFreequency: TextView
    private lateinit var tvMAidNAme: TextView
    private lateinit var tvMAidNAme1: TextView
    private lateinit var btnMaidDetails: Button
    private lateinit var btnMaidDetails1: Button

    private lateinit var firebaseauth: FirebaseAuth
    private lateinit var maidid: String
    private lateinit var maidid1: String

    private lateinit var startdate: String

    private lateinit var firstname: String
    private lateinit var lastname: String
    private lateinit var fullname: String

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_services)

        tvStartDate = findViewById(R.id.ServiceStartdate)
        tvApartmentSize = findViewById(R.id.ServiceApartmentSize)
        tvFreequency = findViewById(R.id.ServicePackage)
        tvMAidNAme = findViewById(R.id.ServiceMAidNAme)
        tvMAidNAme1 = findViewById(R.id.ServiceMAidNAme1)
        btnMaidDetails = findViewById(R.id.ViewMaidDetails)
        btnMaidDetails1 = findViewById(R.id.ViewMaidDetails1)

        firebaseauth = FirebaseAuth.getInstance()
        val uid = firebaseauth.currentUser!!.uid

        val progressDialog = ProgressDialog(this@MyServices)
        progressDialog.setMessage("Book your service..")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)


        val bookingsRef = FirebaseDatabase.getInstance().getReference("bookings")
        val bookings1Ref = bookingsRef.child(uid)


        bookings1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    tvStartDate.text = dataSnapshot.child("startdate").getValue(String::class.java)
                    tvApartmentSize.text =
                        dataSnapshot.child("apartmentsize").getValue(String::class.java)
                    tvFreequency.text =
                        dataSnapshot.child("freequency").getValue(String::class.java)
                    tvMAidNAme.text =
                        dataSnapshot.child("allocatedMaid").getValue(String::class.java)
                    maidid =
                        dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                    tvMAidNAme1.text =
                        dataSnapshot.child("allocatedMaid1").getValue(String::class.java)
                    maidid1 =
                        dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()

                    if (tvApartmentSize.text == "4BHK" || tvApartmentSize.text == "5BHK" || tvApartmentSize.text == "6BHK") {
                        tvMAidNAme1.visibility = View.VISIBLE
                        btnMaidDetails1.visibility = View.VISIBLE
                    }


                } else {
                    btnMaidDetails.visibility = View.INVISIBLE
                    btnMaidDetails1.visibility = View.INVISIBLE
                    val dashboard = findViewById<Button>(R.id.ViewDashboard)
                    dashboard.visibility = View.INVISIBLE
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })




        btnMaidDetails.setOnClickListener {


            val maidRef = FirebaseDatabase.getInstance().getReference("maids")
            val maid1Ref = maidRef.child(maidid)




            maid1Ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {


                    val intent = Intent(this@MyServices, CustomerViewMaid::class.java)
                    Log.e(
                        TAG,
                        snapshot.child("firstname").getValue(String::class.java).toString()
                    )
                    //put extras
                    intent.putExtra(
                        "maidid",
                        snapshot.child("maidid").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "firstname",
                        snapshot.child("firstname").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "area",
                        snapshot.child("area").getValue(String::class.java)
                    )

                    intent.putExtra(
                        "city",
                        snapshot.child("city").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "pin",
                        snapshot.child("pin").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "phonenumber",
                        snapshot.child("phonenumber").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "whatsappnumber",
                        snapshot.child("whatsappnumber").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "alternatenumber",
                        snapshot.child("alternatenumber").getValue(String::class.java)
                    )

                    startActivity(intent)

                }


                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }



        btnMaidDetails1.setOnClickListener {


            val maidRef1 = FirebaseDatabase.getInstance().getReference("maids")
            val maid1Ref1 = maidRef1.child(maidid1)




            maid1Ref1.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    val intent = Intent(this@MyServices, CustomerViewMaid2::class.java)
                    Log.e(
                        TAG,
                        snapshot.child("firstname").getValue(String::class.java).toString()
                    )
                    //put extras
                    intent.putExtra(
                        "maidid",
                        snapshot.child("maidid").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "firstname",
                        snapshot.child("firstname").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "area",
                        snapshot.child("area").getValue(String::class.java)
                    )

                    intent.putExtra(
                        "city",
                        snapshot.child("city").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "pin",
                        snapshot.child("pin").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "phonenumber",
                        snapshot.child("phonenumber").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "whatsappnumber",
                        snapshot.child("whatsappnumber").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "alternatenumber",
                        snapshot.child("alternatenumber").getValue(String::class.java)
                    )

                    startActivity(intent)
                }


                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }

        val dashboard = findViewById<Button>(R.id.ViewDashboard)
        dashboard.setOnClickListener {
            val userRef = FirebaseDatabase.getInstance().getReference("users")
            val user1Ref = userRef.child(firebaseauth.currentUser!!.uid)


            user1Ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    firstname =
                        dataSnapshot.child("firstname").getValue(String::class.java).toString()
                    lastname =
                        dataSnapshot.child("lastname").getValue(String::class.java).toString()

                    fullname = firstname + lastname
                    val intent = Intent(this@MyServices, CustomerDashBoard1::class.java)
                    intent.putExtra("uid", uid)
                    startdate = tvStartDate.text.toString()
                    Log.e(TAG, startdate)
                    intent.putExtra("startdate", startdate)
                    intent.putExtra("firstname", firstname)
                    intent.putExtra("lastname", lastname)
                    intent.putExtra("fullname", fullname)
                    startActivity(intent)

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(TAG, "onCancelled", databaseError.toException())
                }
            })


        }


    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }
}
