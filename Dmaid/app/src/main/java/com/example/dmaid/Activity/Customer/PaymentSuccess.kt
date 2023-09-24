package com.example.dmaid.Activity.Customer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.example.dmaid.Cart
import com.example.dmaid.CustomerHome
import com.example.dmaid.R

class PaymentSuccess : AppCompatActivity() {
    private lateinit var subtoatal  : TextView
    private lateinit var toatal  : TextView
    private lateinit var tax : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_success)
        val total = Cart.ptotal
        subtoatal =  findViewById(R.id.textView45)
        toatal = findViewById(R.id.textView47)
        tax = findViewById(R.id.textView46)

        val tex = total.toDouble() * 0.18
        tax.setText(tex.toString())
        subtoatal.setText(total)
        val tot = total.toDouble() + tex
        toatal.setText(tot.toString())

        Handler().postDelayed({
            val intent = Intent(this, CustomerHome::class.java)
            startActivity(intent)
            finish()
        }, 10000)
    }


}