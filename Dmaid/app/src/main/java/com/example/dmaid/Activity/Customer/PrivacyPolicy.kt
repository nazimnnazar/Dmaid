package com.example.dmaid.Activity.Customer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dmaid.Activity.AdminHome
import com.example.dmaid.Activity.Home
import com.example.dmaid.CustomerHome
import com.example.dmaid.R

class PrivacyPolicy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_policy)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }
}