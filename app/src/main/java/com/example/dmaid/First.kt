package com.example.dmaid

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class First : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)






        val signupbtn = findViewById<ImageButton>(R.id.btn1)
        signupbtn.setOnClickListener {
            val Intent = Intent(this,SendOTP::class.java)
            startActivity(Intent)
        }

        val login = findViewById<TextView>(R.id.textView7)
        login.setOnClickListener {
            val Intent = Intent(this,Login::class.java)
            startActivity(Intent)
        }


        val maidlogin = findViewById<TextView>(R.id.textView71)
        maidlogin.setOnClickListener {
            val Intent = Intent(this,MaidLogin::class.java)
            startActivity(Intent)
        }
    }
}