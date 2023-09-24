package com.example.dmaid

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.Customer.Payment
import com.example.dmaid.Activity.Home
import com.example.dmaid.Models.PaymentDetails
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class Cart : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
   /* private lateinit var startingdate: TextView*/
    private lateinit var apartmentSize: TextView
    private lateinit var conVinientDays: TextView
    private lateinit var Shifts: TextView
    private lateinit var Apartment: TextView
    private lateinit var subtotal: TextView
    private lateinit var subtotal1: TextView
    private lateinit var gst: TextView
    private lateinit var total: TextView
    private lateinit var dbRef: DatabaseReference
    companion object{
    lateinit var  ptotal :String
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        /*startingdate = findViewById(R.id.textView19)*/
        apartmentSize = findViewById(R.id.tv22)
        conVinientDays = findViewById(R.id.tv23)
        Shifts = findViewById(R.id.tv24)
        Apartment = findViewById(R.id.tv25)
        subtotal = findViewById(R.id.textView22)
        subtotal1 = findViewById(R.id.textView28)
      /*  gst = findViewById(R.id.textView29)*/
        total = findViewById(R.id.textView31)
        firebaseAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference("paymentdetails")
        loadUserInfo()

        val confirm = findViewById<Button>(R.id.cbtn)
        confirm.setOnClickListener {
            savePaymentDetails()


        }
    }



    private fun savePaymentDetails() {
        val bid = firebaseAuth.currentUser!!.uid
        val psubtotal = subtotal1.text.toString()
      /*  val pgst = gst.text.toString()*/
        ptotal = total.text.toString()

        val paymentDetails = PaymentDetails(bid, psubtotal, /*pgst,*/ ptotal)

        dbRef.child(bid).setValue(paymentDetails)
            .addOnCompleteListener {
                Toast.makeText(
                    this,
                    "Confirmed",
                    Toast.LENGTH_LONG
                ).show()

                val Intent = Intent(this, Payment::class.java)
                startActivity(Intent)

            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG)
                    .show()
            }






    }

    private fun loadUserInfo() {
        val ref = FirebaseDatabase.getInstance().getReference("bookings")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val startdate  = "${snapshot.child("startdate").value}"
                    val apartmentsize  = "${snapshot.child("apartmentsize").value}"
                    val freequency  = "${snapshot.child("freequency").value}"
                    val days  = "${snapshot.child("days").value}"
                    val shift  = "${snapshot.child("shift").value}"

//                    startingdate.text = startdate
                    apartmentSize.text = apartmentsize
                    conVinientDays.text = freequency
                    Shifts.text = shift

                    Log.e(TAG,apartmentsize)

                    if (apartmentSize.text.equals("4BHK"))
                    {
                        val maidText = findViewById<TextView>(R.id.textView21)
                        maidText.text = "2 Maids"
                    }
                    else if(apartmentSize.text.equals("5BHK"))
                {
                    val maidText = findViewById<TextView>(R.id.textView21)
                    maidText.text = "2 Maids"
                }
                else if(apartmentSize.text.equals("6BHK"))
                {
                    val maidText = findViewById<TextView>(R.id.textView21)
                    maidText.text = "2 Maids"
                }
                    else{
                        val maidText = findViewById<TextView>(R.id.textView21)
                        maidText.text = "1 Maid"
                    }



                    if (apartmentSize.text.equals("1BHK"))
                    {
                        if (conVinientDays.text.equals("Daily"))
                        {
                            subtotal.text = "7150"
                        }
                        else if (conVinientDays.text.equals("Weekly Five Times (W5)")){
                            subtotal.text = "5775"
                        }
                        else if (conVinientDays.text.equals("Weekly Four Times (W4)")){
                            subtotal.text = "5220"
                        }
                        else if (conVinientDays.text.equals("Weekly Three Times (W3)")){
                            subtotal.text = "3900"
                        }
                        else if (conVinientDays.text.equals("Weekly Two Times (W2)")){
                            subtotal.text = "2800"
                        }
                        else{
                            subtotal.text = "1600"
                        }
                    }else if (apartmentSize.text.equals("2BHK")){
                        if (conVinientDays.text.equals("Daily"))
                        {
                            subtotal.text = "7800"
                        }
                        else if (conVinientDays.text.equals("Weekly Five Times (W5)")){
                            subtotal.text = "6300"
                        }
                        else if (conVinientDays.text.equals("Weekly Four Times (W4)")){
                            subtotal.text = "5670"
                        }
                        else if (conVinientDays.text.equals("Weekly Three Times (W3)")){
                            subtotal.text = "4225"
                        }
                        else if (conVinientDays.text.equals("Weekly Two Times (W2)")){
                            subtotal.text = "3200"
                        }
                        else{
                            subtotal.text = "2000"
                        }
                    }else if (apartmentSize.text.equals("3BHK")){
                        if (conVinientDays.text.equals("Daily"))
                        {
                            subtotal.text = "8710"
                        }
                        else if (conVinientDays.text.equals("Weekly Five Times (W5)")){
                            subtotal.text = "7035"
                        }
                        else if (conVinientDays.text.equals("Weekly Four Times (W4)")){
                            subtotal.text = "6300"
                        }
                        else if (conVinientDays.text.equals("Weekly Three Times (W3)")){
                            subtotal.text = "4745"
                        }
                        else if (conVinientDays.text.equals("Weekly Two Times (W2)")){
                            subtotal.text = "3600"
                        }
                        else{
                            subtotal.text = "2200"
                        }
                    }else if (apartmentSize.text.equals("4BHK")){
                        if (conVinientDays.text.equals("Daily"))
                        {
                            subtotal.text = "15600"
                        }
                        else if (conVinientDays.text.equals("Weekly Five Times (W5)")){
                            subtotal.text = "12600"
                        }
                        else if (conVinientDays.text.equals("Weekly Four Times (W4)")){
                            subtotal.text = "11340"
                        }
                        else if (conVinientDays.text.equals("Weekly Three Times (W3)")){
                            subtotal.text = "8450"
                        }
                        else if (conVinientDays.text.equals("Weekly Two Times (W2)")){
                            subtotal.text = "6400"
                        }
                        else{
                            subtotal.text = "4000"
                        }
                    }else if (apartmentSize.text.equals("5BHK")){
                        if (conVinientDays.text.equals("Daily"))
                        {
                            subtotal.text = "16510"
                        }
                        else if (conVinientDays.text.equals("Weekly Five Times (W5)")){
                            subtotal.text = "13335"
                        }
                        else if (conVinientDays.text.equals("Weekly Four Times (W4)")){
                            subtotal.text = "11970"
                        }
                        else if (conVinientDays.text.equals("Weekly Three Times (W3)")){
                            subtotal.text = "8970"
                        }
                        else if (conVinientDays.text.equals("Weekly Two Times (W2)")){
                            subtotal.text = "6800"
                        }
                        else{
                            subtotal.text = "4200"
                        }
                    }
                    else {
                        if (conVinientDays.text.equals("Daily"))
                        {
                            subtotal.text = "17420"
                        }
                        else if (conVinientDays.text.equals("Weekly Five Times (W5)")){
                            subtotal.text = "14070"
                        }
                        else if (conVinientDays.text.equals("Weekly Four Times (W4)")){
                            subtotal.text = "12600"
                        }
                        else if (conVinientDays.text.equals("Weekly Three Times (W3)")){
                            subtotal.text = "9490"
                        }
                        else if (conVinientDays.text.equals("Weekly Two Times (W2)")){
                            subtotal.text = "7200"
                        }
                        else{
                            subtotal.text = "4400"
                        }
                    }

                     subtotal1.text = subtotal.text

                    val amount: Float = subtotal1.text.toString().toFloat()
                /*    val price: Double = amount * 0.18

                    gst.text = price.toString().toFloat().toString()*/
                    
                    val sumtotal: Double = amount.toDouble() //+ price

                    total.text = sumtotal.toString().toFloat().toString()





                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }
}