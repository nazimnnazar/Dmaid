package com.example.dmaid

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.Home
import com.example.dmaid.Activity.maid.Menupage
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class MaidViewBookingDetails : AppCompatActivity() {

    private lateinit var tvdate: TextView
    private lateinit var tvshift: TextView
    private lateinit var tvcustname: TextView
    private lateinit var tvmaidname: TextView
    private lateinit var tvmaidname2: TextView
    private lateinit var tvstatus: TextView

    private lateinit var btnAllocate: Button
    private lateinit var btnUpdateMaid: Button
    private lateinit var btnUpdateStatus: Button

    private lateinit var uid: String
    private lateinit var dbid: String
    private lateinit var ApartmentSize: String
    private lateinit var maidid :String

    private  lateinit var selected: String
    private  lateinit var allotedMiad: String
    private lateinit var propertyAddress: String
    private lateinit var key: String
    private lateinit var keyholder: String

    private  lateinit var selected1: String
    private  lateinit var allotedMiad1: String
    private lateinit var key1: String
    private lateinit var keyholder1: String
    private lateinit var propertyAddress1: String
    private lateinit var date :String
    private lateinit var monYear1: String
    private  lateinit var  nodays :String

    private  lateinit var aparmentSize :String
    private  var noofdays:Float = 0.0f
    private var earnPerDay:Float =0.0f
    var total:Float =0.0f
    var completeted: Float =0.0f

    var earnings : Float = 0.0f
    private lateinit var dateToStr: String
    private  var subtotal : Float = 0.0f


    private lateinit var ddate: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maid_view_booking_details)



        uid = intent.getStringExtra("dcustomerid").toString()
        dbid = intent.getStringExtra("dbid").toString()
        ddate= intent.getStringExtra("ddate").toString()
        maidid = intent.getStringExtra("dmaidid").toString()


        initView()
        setValuesToViews()

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

        val n1 = FirebaseDatabase.getInstance().getReference("bookings")
        val nn1 = n1.child(uid)
        nn1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    noofdays = dataSnapshot.child("noofdays").getValue(String::class.java)!!.toFloat()
                    //TaparmentSize = dataSnapshot.child("apartmentsize").getValue(String::class.java)!!
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })

        //getting days
        val n11 = FirebaseDatabase.getInstance().getReference("bookings")
        val nn11 = n11.child(uid)
        nn11.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    nodays= dataSnapshot.child("freequency").getValue(String::class.java)!!.toString()
                    aparmentSize = dataSnapshot.child("apartmentsize").getValue(String::class.java)!!.toString()

                    if (aparmentSize.equals("3BHK")||aparmentSize.equals("4BHK")||aparmentSize.equals("5BHK")||aparmentSize.equals("6BHK")){
                        if (nodays.equals("Weekly One Time (W1)")){
                            earnPerDay = 550.0F

                        }
                        else if(nodays.equals("Weekly Two Times (W2)")){
                            earnPerDay = 450.0F
                        }
                        else if(nodays.equals("Weekly Three Times (W3)")){
                            earnPerDay = 365.0F
                        }
                        else if(nodays.equals("Weekly Four Times (W4)")){
                            earnPerDay = 350.0F
                        }
                        else if(nodays.equals("Weekly Five Times (W5)")){
                            earnPerDay = 335.0F
                        }
                        else if(nodays.equals("Weekly Six Times (W6)")||nodays.equals("Daily")){
                            earnPerDay = 335.0F
                        }
                    }
                    else if (aparmentSize.equals("2BHK")||aparmentSize.equals("1BHK")){
                        if (nodays.equals("Weekly One Time (W1)")){
                            earnPerDay = 500.0F
                        }
                        else if(nodays.equals("Weekly Two Times (W2)")){
                            earnPerDay = 400.0F
                        }
                        else if(nodays.equals("Weekly Three Times (W3)")){
                            earnPerDay = 325.0F
                        }
                        else if(nodays.equals("Weekly Four Times (W4)")){
                            earnPerDay = 315.0F
                        }
                        else if(nodays.equals("Weekly Five Times (W5)")){
                            earnPerDay = 300.0F
                        }
                        else if(nodays.equals("Weekly Six Times (W6)") || nodays.equals("Daily")){
                            earnPerDay = 300.0F
                        }


                    }
                   // Toast.makeText(this@MaidViewBookingDetails,nodays, Toast.LENGTH_SHORT).show()
                   // Toast.makeText(this@MaidViewBookingDetails,aparmentSize, Toast.LENGTH_SHORT).show()

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })

        val dbRef = FirebaseDatabase.getInstance().getReference("datewisebookings")
        val query = dbRef.orderByChild("dmaidid").equalTo(maidid)

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
               val  total1 = dataSnapshot.childrenCount
                // Use the count value as needed (e.g., display it, perform calculations, etc.)
                // ...
                Log.d("Data Count", total.toString())
                total = total1.toFloat()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle the error condition, if any.
                // ...
            }

        })


        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")

        dbRef1.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var completed = 0

                for (parentSnapshot in dataSnapshot.children) {
                    val maidId = parentSnapshot.child("dmaidid").getValue(String::class.java)
                    val status = parentSnapshot.child("dstatus").getValue(String::class.java)

                    if (maidId == maidid && status == "Completed") {
                        completed++
                    }
                }
                completeted = completed.toFloat()

                // Use the count value as needed
                Log.d("Completed Count", completed.toString())
            }


            override fun onCancelled(databaseError: DatabaseError) {
                // Handle the error condition, if any.
                // ...
            }
        })


        val today = Date()
        val outformat = SimpleDateFormat("yyyy-MM")
        dateToStr= outformat.format(today)





        btnUpdateStatus.visibility = View.VISIBLE
        /*if (ddate == dateToStr) {
            if (tvstatus.length() == 7) {
                btnUpdateStatus.visibility = View.VISIBLE
            }
        }
        else{
            btnUpdateStatus.visibility = View.INVISIBLE
        }*/



        if (tvstatus.text =="Completed") {
            btnUpdateStatus.isEnabled = false
        }

        btnUpdateStatus.setOnClickListener {

            openUpdateStatusDialog(
                intent.getStringExtra("dbid").toString()
            )

        }




    }

    private fun attendance(){
        val bookingsRef1 = FirebaseDatabase.getInstance().getReference("maidearnings")
        val bookings1Ref1 = bookingsRef1.child(dateToStr).child("Attendance_incentive").child(maidid)
        val updates: MutableMap<String, Any> = HashMap()

        val price1: Float = completeted / total
        val amount: Float = price1 * 100
        if (amount >= 90){
            val incetive = earnPerDay * noofdays *0.05
            updates["Attendance_incentive"]=incetive
            bookings1Ref1.updateChildren(updates)
            Toast.makeText(this," updated", Toast.LENGTH_SHORT).show()


        }
    }

    private fun openUpdateStatusDialog(dbid: String) {
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.update_status, null)

        mDialog.setView(mDialogView)

        val status = mDialogView.findViewById<CheckBox>(R.id.chstatus)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)


        attendance()

        mDialog.setTitle("Update Status")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {

            val ref = FirebaseDatabase.getInstance().reference.child("datewisebookings").child(dbid)
            val updates: MutableMap<String, Any> = HashMap()

            if (status.isChecked) {
                updates["dstatus"] = "Completed"
            }

//etc
            Toast.makeText(this," updated", Toast.LENGTH_SHORT).show()

//etc
            ref.updateChildren(updates)

            tvstatus.text ="Completed"
            if (tvstatus.text =="Completed") {
                btnUpdateStatus.isEnabled = false
            }

            val today1 = Date()
            val outformat1 = SimpleDateFormat("yyyy-MM")
            monYear1= outformat1.format(today1)
            val date1 = SimpleDateFormat("dd")
            date = date1.format(today1)

            val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(monYear1).child(date).child(maidid)
            val updates1: MutableMap<String, Any> = HashMap()
            earnings = (earnPerDay* 0.5).toFloat()
            Log.e(ContentValues.TAG, earnings.toString())
            updates1["Base_earning"] = earnings
            updates1["direct_earnings"] = earnings

            ref1.updateChildren(updates1)
            val ref12 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(monYear1).child(maidid)
            val updates12: MutableMap<String, Any> = HashMap()


            Log.e(ContentValues.TAG, earnings.toString())


            updates12["Base_earning"] = earnPerDay.toInt()
            updates12["noofdays"] = noofdays

            ref12.updateChildren(updates12)



            alertDialog.dismiss()
        }
    }


    private fun setValuesToViews() {
        tvdate.text = intent.getStringExtra("ddate")
        tvshift.text = intent.getStringExtra("dshift")
        tvcustname.text = intent.getStringExtra("dcustomername")
        tvstatus.text = intent.getStringExtra("dstatus")
    }

    private fun initView() {
        tvdate = findViewById(R.id.tvDate)
        tvshift = findViewById(R.id.tvShift)
        tvcustname = findViewById(R.id.tvCustName)
        tvstatus = findViewById(R.id.tvStatus)

        btnUpdateStatus = findViewById(R.id.UpadteStatus)
    }
    override fun onBackPressed() {
        super.onBackPressed()

    }

}