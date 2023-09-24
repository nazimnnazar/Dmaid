package com.example.dmaid.Activity.Customer

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.AdminHome
import com.example.dmaid.Activity.Home
import com.example.dmaid.CustomerHome
import com.example.dmaid.First
import com.example.dmaid.Models.MaidReview
import com.example.dmaid.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import java.text.SimpleDateFormat
import java.util.*

class RateMaid : AppCompatActivity() {

    private lateinit var cleaning: SeekBar
    private  var cleaningRate: String=""

    private lateinit var grooming: SeekBar
    private  var groomingRate: String=""

    /*private lateinit var attention: SeekBar*/
   /* private lateinit var attentionRate: String*/
    private var earnPerDay:Float =0.0f
    private var aparmentSize : String = ""


    private lateinit var btnRate: Button

    private lateinit var maidiid: String
    private lateinit var commentss: EditText
    private lateinit var rateLate : TextView

    private lateinit var dbRef: DatabaseReference

    private lateinit var firebaseauth: FirebaseAuth
    private lateinit var uid: String
    private lateinit var dateToStr: String
    private lateinit var date: String

    private var direct: Float = 0.0f
    var revearnings :Float = 0.0f

    private  var subtotal : Float = 0.0f
    private  var nodays : Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_maid)

        cleaning = findViewById(R.id.skCleaning)
        grooming = findViewById(R.id.skGrooming)
      /*  attention = findViewById(R.id.skAttention)*/
        btnRate = findViewById(R.id.btnRate)
        commentss = findViewById(R.id.edcomments)
        rateLate = findViewById(R.id.textView63)

        dbRef = FirebaseDatabase.getInstance().getReference("bookings")

        maidiid = intent.getStringExtra("maidid").toString()

        firebaseauth = FirebaseAuth.getInstance()

        uid = firebaseauth.currentUser!!.uid

        cleaning.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                    val progress = p0?.progress ?: 0
                    val convertedProgress = progress // Add 1 to convert the range from 0-5 to 1-6
                    Toast.makeText(this@RateMaid, "Cleaning rate: $convertedProgress", Toast.LENGTH_SHORT).show()
                    cleaningRate = convertedProgress.toString()
                }
                /*Toast.makeText(this@RateMaid,
                    "cleaning rate : " + cleaning.progress ,
                    Toast.LENGTH_SHORT).show()
                cleaningRate = cleaning.progress.toString()
            }*/

        })


        grooming.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                    val progress = p0?.progress ?: 0
                    val convertedProgress = progress // Add 1 to convert the range from 0-5 to 1-6
                    Toast.makeText(this@RateMaid, "Grooming rate :  $convertedProgress", Toast.LENGTH_SHORT).show()
                    groomingRate = convertedProgress.toString()
                }
                /*Toast.makeText(this@RateMaid,
                    "Grooming rate : " + grooming.progress ,
                    Toast.LENGTH_SHORT).show()
                groomingRate = grooming.progress.toString()
            }*/

        })


        /*attention.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                    val progress = p0?.progress ?: 0
                    val convertedProgress = progress  // Add 1 to convert the range from 0-5 to 1-6
                    Toast.makeText(this@RateMaid, "Attention to detailing rate :  $convertedProgress", Toast.LENGTH_SHORT).show()
                    attentionRate = convertedProgress.toString()
                }
               *//* Toast.makeText(this@RateMaid,
                    "Attention to detailing rate : " + attention.progress ,
                    Toast.LENGTH_SHORT).show()
                attentionRate = attention.progress.toString()
            }*//*

        })*/

        val today = Date()
        val outformat = SimpleDateFormat("yyyy-MM")
        dateToStr= outformat.format(today)
        val date1 = SimpleDateFormat("dd")
        date = date1.format(today)


        val n1 = FirebaseDatabase.getInstance().getReference("maidearnings").child(dateToStr)
        val nn1 = n1.child(maidiid)
        nn1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    nodays = dataSnapshot.child("Base_earning").getValue(Int::class.java)!!.toFloat()
                    //aparmentSize = dataSnapshot.child("apartmentsize").getValue(String::class.java)!!
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })

        if (aparmentSize.equals("3BHK")){
            if (nodays.equals(4)){
                earnPerDay = 550.0F
            }
            else if(nodays.equals(8)){
                earnPerDay = 450.0F
            }
            else if(nodays.equals(13)){
                earnPerDay = 365.0F
            }
            else if(nodays.equals(18)){
                earnPerDay = 350.0F
            }
            else if(nodays.equals(21)){
                earnPerDay = 335.0F
            }
            else if(nodays.equals(26)){
                earnPerDay = 335.0F
            }
        }
        else if (aparmentSize.equals("2BHK")){
            if (nodays.equals(4)){
                earnPerDay = 500.0F
            }
            else if(nodays.equals(8)){
                earnPerDay = 400.0F
            }
            else if(nodays.equals(13)){
                earnPerDay = 325.0F
            }
            else if(nodays.equals(18)){
                earnPerDay = 315.0F
            }
            else if(nodays.equals(21)){
                earnPerDay = 300.0F
            }
            else if(nodays.equals(26)){
                earnPerDay = 300.0F
            }

        }





        val bookingsRef = FirebaseDatabase.getInstance().getReference("paymentdetails")
        val bookings1Ref = bookingsRef.child(uid)
        bookings1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    subtotal = dataSnapshot.child("psubtotal").getValue(String::class.java)!!.toFloat()

                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })


        btnRate.setOnClickListener {
            if (!groomingRate.equals("") || !cleaningRate.equals("")) {
                saveMaidReview()
                super.onBackPressed()



                Handler().postDelayed(Runnable {
                    startActivity(Intent(this, MyServices::class.java))
                    finish()
                }, 2)
            }
            else{
                Toast.makeText(this@RateMaid,"Ratings will be only from 1 to 5",Toast.LENGTH_SHORT).show()
            }
            //super.onBackPressed()
        }
        rateLate.setOnClickListener {
            val intent = Intent(this, MyServices::class.java)
            startActivity(intent)
        }

    }

    private fun saveMaidReview() {
        val maidid = maidiid
        val cleaning = cleaningRate
        val grooming = groomingRate
       /* val attention = attentionRate*/
        val comments = commentss.text.toString()


       /* val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
        val updates1: MutableMap<String, Any> = HashMap()

        Log.e(ContentValues.TAG, nodays.toString())
        val earnings = subtotal/nodays
        val earn = earnings.toInt() * 0.5

        updates1["noofdays"] = nodays
        updates1["Base_earning"] = earn*/


       // ref1.updateChildren(updates1)

        if (cleaningRate == "9")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = earnPerDay * 0.05
            val amount1: Double = amount /** nodays*/
            revearnings = amount1.toFloat()//.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Cleaning_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        else if (cleaningRate == "5")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = nodays * 0.05
            val amount1: Double = amount //* nodays
            revearnings = amount1.toFloat()//.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Cleaning_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }

        /*else if (attentionRate == "9")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = price1 * 0.05
            val amount1: Double = amount * nodays
            revearnings = amount1.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["review_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        else if (attentionRate == "5")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = price1 * 0.05
            val amount1: Double = amount * nodays
            revearnings = amount1.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["review_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }*/
        else if (cleaningRate == "4")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = nodays * 0.05
            val amount1: Double = amount /** nodays*/
            revearnings = amount1.toFloat()//.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Cleaning_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        else if (cleaningRate == "3")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = nodays * 0.025
            val amount1: Double = amount /** nodays*/
            revearnings = amount1.toFloat()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Cleaning_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        /*else if (attentionRate == "3")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = price1 * 0.025
            val amount1: Double = amount * nodays
            revearnings = amount1.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["review_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        else if (attentionRate == "4")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = price1 * 0.05
            val amount1: Double = amount * nodays
            revearnings = amount1.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["review_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }*/
        else{
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            Log.e(TAG, "this  is calling   bullshit")
            updates1["Cleaning_incentive"] = 0.00

            ref1.updateChildren(updates1)
        }

        if (groomingRate == "9")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = nodays * 0.05
            val amount1: Double = amount /** nodays*/
            revearnings = amount1.toFloat()//.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Grooming_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        else if (groomingRate == "5")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = nodays * 0.05
            val amount1: Double = amount /** nodays*/
            revearnings = amount1.toFloat()//.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Grooming_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        else if (groomingRate == "4")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = nodays * 0.05
            val amount1: Double = amount/* * nodays*/
            revearnings = amount1.toFloat()//.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Grooming_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        else if (groomingRate == "3")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()


            val price1: Float = subtotal / nodays
            val amount: Double = nodays * 0.025
            val amount1: Double = amount /** nodays*/
            revearnings = amount1.toFloat()//o.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Grooming_incentive"] = revearnings
            ref1.updateChildren(updates1)
        }
        else{
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            Log.e(TAG, "this  is calling   bullshit")
            updates1["Grooming_incentive"] = 0.00

            ref1.updateChildren(updates1)
        }


        if (cleaning.isNotEmpty()) {
            if (grooming.isNotEmpty()) {
                /*if (attention.isNotEmpty()) {*/

                    val maidreview = MaidReview(maidid, cleaning, grooming,/* attention,*/ comments)

                   /* dbRef.child(uid).child(maidid).setValue(maidreview)
                        .addOnCompleteListener {
                            Toast.makeText(
                                this,
                                "Rated Successfully",
                                Toast.LENGTH_LONG
                            ).show()

                            commentss.text.clear()

                        }.addOnFailureListener { err ->
                            Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG)
                                .show()
                        }*/

                } else {
                    Toast.makeText(this, "Please rate based on attention to detailing..", Toast.LENGTH_LONG)
                        .show()
                }
            } else {
                Toast.makeText(this, "Please rate based on grooming..", Toast.LENGTH_LONG)
                    .show()
            }
        } /*else {
            Toast.makeText(this, "Please rate based on cleaning..", Toast.LENGTH_LONG)
                .show()
        }


    }*/
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }
}