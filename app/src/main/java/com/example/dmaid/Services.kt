package com.example.dmaid

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Services : AppCompatActivity() {

    private lateinit var backbtn: ImageView

    private lateinit var firebaseauth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)



        val bookbtn = findViewById<Button>(R.id.bookBtn)
        firebaseauth = FirebaseAuth.getInstance()
        val uid = firebaseauth.currentUser!!.uid

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
                        val Intent = Intent(this@Services, DateSelection::class.java)
                        startActivity(Intent)
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


}