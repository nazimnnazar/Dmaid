package com.example.dmaid.Activity.maid

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.AdminHome
import com.example.dmaid.First
import com.example.dmaid.R
import com.example.dmaid.Signup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Menupage : AppCompatActivity() {

    private lateinit var welcomemaid: TextView

    private lateinit var homeBtn: Button

    private lateinit var maidid: String
    private lateinit var maidfirstname: String
    private lateinit var maidlastname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menupage)

        welcomemaid = findViewById(R.id.maidtv)
        homeBtn = findViewById(R.id.homebtn)



        maidid = intent.getStringExtra("maidid").toString()
        Log.e("TAG", maidid)


        val maidRef = FirebaseDatabase.getInstance().getReference("maids")
        val maid1Ref = maidRef.child(maidid)

        maid1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                maidfirstname = dataSnapshot.child("firstname").getValue(String::class.java).toString()
                maidlastname = dataSnapshot.child("lastname").getValue(String::class.java).toString()

               welcomemaid.text = "Welcome $maidfirstname $maidlastname"

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })





        homeBtn.setOnClickListener {
            val intent = Intent(this, Secondpage::class.java)
            intent.putExtra("maidid",maidid)

            startActivity(intent)
        }
        val logout = findViewById<ImageButton>(R.id.logout)
        logout.setOnClickListener {
            val intent = Intent(this, First::class.java)
            intent.putExtra("maidid",maidid)

            startActivity(intent)
        }

        val earnings = findViewById<Button>(R.id.earnings)
        earnings.setOnClickListener {
            val intent = Intent(this, Earnings::class.java)
            intent.putExtra("maidid",maidid)

            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, First::class.java)
        startActivity(intent)
        finish()
    }
}