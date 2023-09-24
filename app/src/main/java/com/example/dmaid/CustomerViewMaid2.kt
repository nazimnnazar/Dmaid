package com.example.dmaid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.Customer.RateMaid

class CustomerViewMaid2 : AppCompatActivity() {

    private lateinit var tvname: TextView
    private lateinit var tvArea: TextView
    private lateinit var tvCity: TextView
    private lateinit var tvPin: TextView
    private lateinit var tvContactNumber: TextView
    private lateinit var tvWhatsappNumber: TextView
    private lateinit var tvALternateNumber: TextView
    private lateinit var btnRate: Button
    private lateinit var maidid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_view_maid2)

        tvname = findViewById(R.id.mname)
        tvArea = findViewById(R.id.marea)
        tvCity = findViewById(R.id.mcity)
        tvPin = findViewById(R.id.mpin)
        tvContactNumber = findViewById(R.id.mcontactnumber)
        tvWhatsappNumber = findViewById(R.id.mwhatsappnumber)
        tvALternateNumber = findViewById(R.id.malternatenumber)
        btnRate = findViewById(R.id.btnRateMaid)
        setValuesToViews()

        if (tvname.text.isEmpty())
        {
            setContentView(R.layout.maid_allocation_error_page)
        }


        btnRate.setOnClickListener {
            val intent = Intent(this, RateMaid::class.java)
            intent.putExtra("maidid",maidid)
            startActivity(intent)
        }
    }

    private fun setValuesToViews() {
        tvname.text = intent.getStringExtra("firstname")
        tvArea.text = intent.getStringExtra("area")
        tvCity.text = intent.getStringExtra("city")
        tvPin.text = intent.getStringExtra("pin")
        maidid = intent.getStringExtra("maidid").toString()
        tvContactNumber.text = intent.getStringExtra("phonenumber")
        tvWhatsappNumber.text = intent.getStringExtra("whatsappnumber")
        tvALternateNumber.text = intent.getStringExtra("alternatenumber")

    }
}