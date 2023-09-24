package com.example.dmaid

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.Home
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Services : AppCompatActivity() {

    private lateinit var backbtn: ImageView

    private lateinit var firebaseauth: FirebaseAuth
    private  lateinit var name: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)





        val bookbtn = findViewById<Button>(R.id.bookBtn)
        firebaseauth = FirebaseAuth.getInstance()
        val uid = firebaseauth.currentUser!!.uid

        val databaseRef = FirebaseDatabase.getInstance().getReference().child("users").child(uid)

        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val firstname = dataSnapshot.child("firstname").getValue(String::class.java)
                    val lastname = dataSnapshot.child("lastname").getValue(String::class.java)
                    name = firstname+lastname
                } else {
                    // Handle the case when the data doesn't exist
                    // ...
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle any errors that occur
            }
        })

        bookbtn.setOnClickListener {



            val bookingsRef = FirebaseDatabase.getInstance().getReference("bookings")
            val bookings1Ref = bookingsRef.child(uid)


            bookings1Ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists())
                    {
                        Toast.makeText(this@Services,"Since You have already booked a service...You can book the service after it's expiry",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        val reference = FirebaseDatabase.getInstance().getReference().child("datewisebookings")

                        val query = reference.orderByChild("dcustomerid").equalTo(uid)

                        query.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(dataSnapshot: DataSnapshot) {
                                if (dataSnapshot.exists()) {

                                    Toast.makeText(this@Services,"Since You have already booked a service...You can book the service after it's expiry",Toast.LENGTH_SHORT).show()

                                }else {
                                    val Intent = Intent(this@Services, DateSelection::class.java)
                                    startActivity(Intent)
                                }
                            }

                            override fun onCancelled(databaseError: DatabaseError) {
                                // Handle the error
                            }
                        })
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                }
            })





        }

        backbtn = findViewById(R.id.backbtn)
        backbtn.setOnClickListener{
            onBackPressed()
        }



    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }


}