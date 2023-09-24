package com.example.dmaid

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.AdminHome
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*


class CustomerDetails : AppCompatActivity() {

    private lateinit var tvFname: TextView
    private lateinit var tvLname: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvApartment: TextView
    private lateinit var tvFamSize: TextView
    private lateinit var tvPin: TextView
    private lateinit var tvSpouseName: TextView
    private lateinit var tvDoorNo: TextView
    private lateinit var tvContactNumber: TextView
    private lateinit var tvWhatsappNumber: TextView

    private lateinit var btnDelete: Button
    private lateinit var uid: String

    private lateinit var startdate: String

    private lateinit var dbRef: DatabaseReference

    private lateinit var firstname : String
    private lateinit var lastname : String
    private lateinit var fullname : String


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_details)

        uid = intent.getStringExtra("uid").toString()



        initView()
        setValuesToViews()




        val viewBookings = findViewById<Button>(R.id.btnViewBookings)
        viewBookings.setOnClickListener {
            getUserBookingDetails()

        }
        if (uid.equals(null))
        {
               viewBookings.visibility = android.view.View.INVISIBLE
        }


        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("uid").toString()
            )
        }
    }

    private fun getUserBookingDetails() {

        val bookref = FirebaseDatabase.getInstance().getReference("bookings")
        val bookref1 = bookref.child(uid)
        val startingdate = bookref1.child("startdate")




        bookref1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    Log.e(
                        TAG,
                        dataSnapshot.child("startdate").getValue(String::class.java)!!
                    )
                    Log.e(
                        TAG,
                        dataSnapshot.child("apartmentsize").getValue(String::class.java)!!
                    )
                    Log.e(
                        TAG,
                        dataSnapshot.child("freequency").getValue(String::class.java)!!
                    )
                    Log.e(
                        TAG,
                        dataSnapshot.child("days").getValue(String::class.java)!!
                    )
                    Log.e(
                        TAG,
                        dataSnapshot.child("shift").getValue(String::class.java)!!
                    )


                    val intent = Intent(this@CustomerDetails, AdminViewBookings::class.java)

                    //put extras
                    intent.putExtra("uid", uid)
                    intent.putExtra(
                        "startdate",
                        dataSnapshot.child("startdate").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "apartmentsize",
                        dataSnapshot.child("apartmentsize").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "freequency",
                        dataSnapshot.child("freequency").getValue(String::class.java)
                    )
                    intent.putExtra("days", dataSnapshot.child("days").getValue(String::class.java))
                    intent.putExtra(
                        "shift",
                        dataSnapshot.child("shift").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "allocatedMaid",
                        dataSnapshot.child("allocatedMaid").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "allocatedMaid1",
                        dataSnapshot.child("allocatedMaid1").getValue(String::class.java)
                    )
                    intent.putExtra(
                        "noofdays",
                        dataSnapshot.child("noofdays").getValue(String::class.java)
                    )

                    firstname = tvFname.text.toString()
                    lastname = tvLname.text.toString()
                    fullname = firstname + lastname
                    Log.e(TAG,fullname)
                    intent.putExtra("firstname",firstname)
                    intent.putExtra("lastname",lastname)
                    intent.putExtra("fullname",fullname)



                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@CustomerDetails,"Customer Booking Details is Empty..",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })

    }

    private fun deleteRecord(uid: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("users").child(uid)
        val mTask = dbRef.removeValue()
        val dbref1 = FirebaseDatabase.getInstance().getReference("bookings").child(uid)
        val task1 = dbref1.removeValue()


        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("datewisebookings")

        // Query to find the child node with matching dcustomerid
        val query = reference.orderByChild("dcustomerid").equalTo(uid)

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (childSnapshot in dataSnapshot.children) {
                    val key = childSnapshot.key
                    // Delete the child node
                    reference.child(key!!).removeValue()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle the error
            }
        })






        task1.addOnSuccessListener {

        }.addOnFailureListener{ error ->
            Toast.makeText(this, "Deleting failed due to ${error.message}", Toast.LENGTH_LONG).show()
        }


        mTask.addOnSuccessListener {
            Toast.makeText(this, "Customer data deleted", Toast.LENGTH_LONG).show()

            val intent = Intent(this, AdminViewCustomers::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{ error ->
            Toast.makeText(this, "Deleting failed due to ${error.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun setValuesToViews() {

        tvFname.text = intent.getStringExtra("firstname")
        tvLname.text = intent.getStringExtra("lastname")
        tvAddress.text = intent.getStringExtra("address")
        tvEmail.text = intent.getStringExtra("email")
        tvApartment.text = intent.getStringExtra("apartment")
        tvFamSize.text = intent.getStringExtra("familysize")
        tvPin.text = intent.getStringExtra("pin")
        tvSpouseName.text = intent.getStringExtra("spousename")
        tvDoorNo.text = intent.getStringExtra("doorNo")
        tvContactNumber.text = intent.getStringExtra("contactnumber")
        tvWhatsappNumber.text = intent.getStringExtra("whatsappnumber")

    }

    private fun initView() {


        tvFname = findViewById(R.id.tvfname)
        tvLname = findViewById(R.id.tvlnmae)
        tvAddress = findViewById(R.id.tvaddress)
        tvEmail = findViewById(R.id.tvemail)
        tvApartment = findViewById(R.id.tvapartment)
        tvFamSize = findViewById(R.id.tvfam)
        tvPin = findViewById(R.id.tvpin)
        tvSpouseName = findViewById(R.id.tvspousename)
        tvDoorNo = findViewById(R.id.tvdoorno)
        tvContactNumber = findViewById(R.id.tvcontactnum)
        tvWhatsappNumber = findViewById(R.id.tvwhatsappNum)


        btnDelete = findViewById(R.id.btnDelete)

    }
    override fun onBackPressed() {

        val intent = Intent(this, AdminHome::class.java)
        startActivity(intent)
        finish()
    }
}