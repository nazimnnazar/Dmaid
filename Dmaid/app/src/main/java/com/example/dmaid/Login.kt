package com.example.dmaid

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.AdminHome
import com.example.dmaid.Activity.Home
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Login : AppCompatActivity() {
    private lateinit var loginBtn: ImageButton
    private lateinit var signup: TextView
    private lateinit var email: EditText
    private lateinit var Pword: EditText
    private lateinit var uid: String

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signup = findViewById(R.id.textView8)
        loginBtn = findViewById(R.id.imageButton)
        email = findViewById(R.id.ed1)
        Pword = findViewById(R.id.ed2)

        signup.setOnClickListener {
            val Intent = Intent(this,Signup::class.java)
            startActivity(Intent)
        }

        firebaseAuth = FirebaseAuth.getInstance()


        loginBtn.setOnClickListener {

            val email = email.text.toString()
            val pass = Pword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        if(email.equals("dmaidadmin01@gmail.com")) {

                            val zonesRef = FirebaseDatabase.getInstance().getReference("users")

                            Toast.makeText(this,"logging in .. .",Toast.LENGTH_SHORT).show()
                            zonesRef.addValueEventListener(object : ValueEventListener {


                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    for (zoneSnapshot in dataSnapshot.children) {
                                        uid = zoneSnapshot.child("uid").getValue(String::class.java).toString()
                                        Log.e(ContentValues.TAG,uid)

                                        val intent = Intent(this@Login, AdminHome::class.java)
                                        intent.putExtra("uid", uid)


                                        startActivity(intent)
                                        Log.e(ContentValues.TAG,"logging in .....")


                                    }
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                                }
                            })




                        }else {
                            val intent = Intent(this, CustomerHome::class.java)
                            startActivity(intent)
                        }

                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }


        }



    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, First::class.java)
        startActivity(intent)
        finish()
    }


}

