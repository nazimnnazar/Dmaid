package com.example.dmaid.Activity.Customer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.R

class Payment : AppCompatActivity() {
    private lateinit var cfrbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        cfrbtn = findViewById(R.id.confirmbtn)
        cfrbtn.setOnClickListener {
            val intent = Intent(this, PaymentSuccess::class.java)
            startActivity(intent)
            finish()
        }



    }
}