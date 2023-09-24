package com.example.dmaid.Activity.Customer

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Models.MaidReview
import com.example.dmaid.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class RateMaid : AppCompatActivity() {

    private lateinit var cleaning: SeekBar
    private lateinit var cleaningRate: String

    private lateinit var grooming: SeekBar
    private lateinit var groomingRate: String

    private lateinit var attention: SeekBar
    private lateinit var attentionRate: String


    private lateinit var btnRate: Button

    private lateinit var maidiid: String
    private lateinit var commentss: EditText

    private lateinit var dbRef: DatabaseReference

    private lateinit var firebaseauth: FirebaseAuth
    private lateinit var uid: String
    private lateinit var dateToStr: String

    private var direct: Float = 0.0f
    var revearnings = 0

    private  var subtotal : Float = 0.0f
    private  var nodays : Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_maid)

        cleaning = findViewById(R.id.skCleaning)
        grooming = findViewById(R.id.skGrooming)
        attention = findViewById(R.id.skAttention)
        btnRate = findViewById(R.id.btnRate)
        commentss = findViewById(R.id.edcomments)

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
                Toast.makeText(this@RateMaid,
                    "cleaning rate : " + cleaning.progress ,
                    Toast.LENGTH_SHORT).show()
                cleaningRate = cleaning.progress.toString()
            }

        })


        grooming.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@RateMaid,
                    "Grooming rate : " + grooming.progress ,
                    Toast.LENGTH_SHORT).show()
                groomingRate = grooming.progress.toString()
            }

        })

        attention.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@RateMaid,
                    "Attention to detailing rate : " + attention.progress ,
                    Toast.LENGTH_SHORT).show()
                attentionRate = attention.progress.toString()
            }

        })

        val today = Date()
        val outformat = SimpleDateFormat("yyyy-MM")
        dateToStr= outformat.format(today)


        val n1 = FirebaseDatabase.getInstance().getReference("bookings")
        val nn1 = n1.child(uid)
        nn1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    nodays = dataSnapshot.child("noofdays").getValue(String::class.java)!!.toFloat()
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })


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
            saveMaidReview()
        }
    }

    private fun saveMaidReview() {
        val maidid = maidiid
        val cleaning = cleaningRate
        val grooming = groomingRate
        val attention = attentionRate
        val comments = commentss.text.toString()


        if (cleaningRate == "9")
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
        else if (cleaningRate == "10")
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
        else if (attentionRate == "9")
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
        else if (attentionRate == "10")
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
        else if (cleaningRate == "8")
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
        else if (cleaningRate == "7")
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
        else if (attentionRate == "8")
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
        else if (attentionRate == "7")
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
        else{
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            Log.e(TAG, "this  is calling   bullshit")
            updates1["review_incentive"] = 0.00

            ref1.updateChildren(updates1)
        }

        if (groomingRate == "9")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = price1 * 0.05
            val amount1: Double = amount * nodays
            revearnings = amount1.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Grooming_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        else if (groomingRate == "10")
        {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            val price1: Float = subtotal / nodays
            val amount: Double = price1 * 0.05
            val amount1: Double = amount * nodays
            revearnings = amount1.toInt()

            Log.e(ContentValues.TAG, revearnings.toString())

            updates1["Grooming_incentive"] = revearnings

            ref1.updateChildren(updates1)
        }
        else{
            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidiid)
            val updates1: MutableMap<String, Any> = HashMap()

            Log.e(TAG, "this  is calling   bullshit")
            updates1["Grooming_incentive"] = 0.00

            ref1.updateChildren(updates1)
        }


        if (cleaning.isNotEmpty()) {
            if (grooming.isNotEmpty()) {
                if (attention.isNotEmpty()) {

                            val maidreview = MaidReview(maidid, cleaning, grooming, attention, comments)

                            dbRef.child(uid).child(maidid).setValue(maidreview)
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
                                }

                } else {
                    Toast.makeText(this, "Please rate based on attention to detailing..", Toast.LENGTH_LONG)
                    .show()
                }
            } else {
                Toast.makeText(this, "Please rate based on grooming..", Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            Toast.makeText(this, "Please rate based on cleaning..", Toast.LENGTH_LONG)
                .show()
        }


    }
}