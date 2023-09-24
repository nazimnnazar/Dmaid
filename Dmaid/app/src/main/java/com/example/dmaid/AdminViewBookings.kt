package com.example.dmaid

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.AdminHome
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class AdminViewBookings : AppCompatActivity() {

    private lateinit var tvStartDate: TextView
    private lateinit var tvApartmentSize: TextView
    private lateinit var tvFreequency: TextView
    private lateinit var tvDays: TextView
    private lateinit var tvConvinientTime: TextView
    private lateinit var btnAllot: Button
    private lateinit var tvAllotedMaid: TextView


    private lateinit var maid2tv: TextView
    private lateinit var allotedmaid2tv: TextView

    private  lateinit var selected: String
    private  lateinit var allotedMiad: String
    private lateinit var propertyAddress: String
    private lateinit var key: String
    private lateinit var keyholder: String


    private lateinit var nodays:String

    private  lateinit var selected1: String
    private  lateinit var allotedMiad1: String
    private lateinit var key1: String
    private lateinit var keyholder1: String
    private lateinit var propertyAddress1: String

    private lateinit var uid: String
    private lateinit var date: String

    private lateinit var datelist: Array<String>

    private lateinit var fullname : String


    var date02 = ""
    var date03 = ""
    var date04 = ""
    var date05 = ""
    var date06 = ""
    var date07 = ""
    var date08 = ""
    var date09 = ""
    var date10 = ""
    var date11 = ""
    var date12 = ""
    var date13 = ""
    var date14 = ""
    var date15 = ""
    var date16 = ""
    var date17 = ""
    var date18 = ""
    var date19 = ""
    var date20 = ""
    var date21 = ""
    var date22 = ""
    var date23 = ""
    var date24 = ""
    var date25 = ""
    var date26 = ""
    var date27 = ""
    var date28 = ""
    var date29 = ""
    var date30 = ""


    private lateinit var goal :String
    private lateinit var goal1 :String
    private lateinit var goal2 :String
    private lateinit var goal3 :String
    private lateinit var goal4 :String
    private lateinit var goal5 :String
    private lateinit var goal6:String
    private lateinit var goal7 :String
    private lateinit var goal8 :String
    private lateinit var goal9 :String
    private lateinit var goal10 :String
    private lateinit var goal11 :String
    private lateinit var goal12 :String
    private lateinit var goal13 :String
    private lateinit var goal14 :String
    private lateinit var goal15 :String
    private lateinit var goal16 :String
    private lateinit var goal17 :String
    private lateinit var goal18 :String
    private lateinit var goal19 :String
    private lateinit var goal20 :String
    private lateinit var goal21 :String
    private lateinit var goal22 :String
    private lateinit var goal23 :String
    private lateinit var goal24 :String
    private lateinit var goal25 :String
    private lateinit var goal26 :String
    private lateinit var goal27 :String
    private lateinit var goal28 :String
    private lateinit var goal29 :String

    private lateinit var startdate: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_view_bookings)

        tvStartDate = findViewById(R.id.tvStartDate)
        tvApartmentSize = findViewById(R.id.tvApartmentSize)
        tvFreequency = findViewById(R.id.tvFreequency)
        tvDays = findViewById(R.id.tvDays)
        tvConvinientTime = findViewById(R.id.tvConvinientTime)
        btnAllot = findViewById(R.id.btnAllocate)
        tvAllotedMaid = findViewById(R.id.tvallotedMaid)

        maid2tv = findViewById(R.id.allotedm2tv)
        allotedmaid2tv = findViewById(R.id.tvallotedMaid2)



        uid = intent.getStringExtra("uid").toString()

        fullname = intent.getStringExtra("fullname")!!
        startdate = intent.getStringExtra("startdate")!!


        val inFormat = SimpleDateFormat("dd-MM-yyyy")
        val outFormat = SimpleDateFormat("EEEE")
        Log.e(TAG,startdate)

        val format1 = SimpleDateFormat("dd")

        // day 2

        try {
            val myDate = inFormat.parse(startdate)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date02 = inFormat.format(newDate)

        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date02)


        val inFormat1 = SimpleDateFormat("dd-MM-yyyy")
        val date1: Date? = inFormat1.parse(date02)
        val outFormat1 = SimpleDateFormat("EEEE")
        goal1 = outFormat1.format(date1)

        Log.e(ContentValues.TAG,goal1)


        // day 3

        try {
            val myDate = inFormat.parse(date02)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date03 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date03)

        val inFormat2 = SimpleDateFormat("dd-MM-yyyy")
        val date2: Date? = inFormat2.parse(date03)
        val outFormat2 = SimpleDateFormat("EEEE")
        goal2 = outFormat2.format(date2)

        Log.e(ContentValues.TAG,goal2)


        // day 4

        try {
            val myDate = inFormat.parse(date03)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date04 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date04)

        val inFormat3 = SimpleDateFormat("dd-MM-yyyy")
        val date3: Date? = inFormat3.parse(date04)
        val outFormat3 = SimpleDateFormat("EEEE")
        goal3 = outFormat3.format(date3)

        Log.e(ContentValues.TAG,goal3)

        // day 5

        try {
            val myDate = inFormat.parse(date04)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date05 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date05)

        val inFormat4 = SimpleDateFormat("dd-MM-yyyy")
        val date4: Date? = inFormat4.parse(date05)
        val outFormat4 = SimpleDateFormat("EEEE")
        goal4 = outFormat4.format(date4)

        Log.e(ContentValues.TAG,goal4)

        // day 6

        try {
            val myDate = inFormat.parse(date05)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date06 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date06)

        val inFormat5 = SimpleDateFormat("dd-MM-yyyy")
        val date5: Date? = inFormat5.parse(date06)
        val outFormat5 = SimpleDateFormat("EEEE")
        goal5 = outFormat5.format(date5)

        Log.e(ContentValues.TAG,goal5)

        // day 7

        try {
            val myDate = inFormat.parse(date06)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date07 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date07)

        val inFormat6 = SimpleDateFormat("dd-MM-yyyy")
        val date6: Date? = inFormat6.parse(date07)
        val outFormat6 = SimpleDateFormat("EEEE")
        goal6 = outFormat6.format(date6)

        Log.e(ContentValues.TAG,goal6)

        // day 8

        try {
            val myDate = inFormat.parse(date07)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date08 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date08)

        val inFormat7 = SimpleDateFormat("dd-MM-yyyy")
        val date7: Date? = inFormat7.parse(date08)
        val outFormat7 = SimpleDateFormat("EEEE")
        goal7 = outFormat7.format(date7)

        Log.e(ContentValues.TAG,goal7)

        // day 9

        try {
            val myDate = inFormat.parse(date08)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date09 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date09)

        val inFormat8 = SimpleDateFormat("dd-MM-yyyy")
        val date8: Date? = inFormat8.parse(date09)
        val outFormat8 = SimpleDateFormat("EEEE")
        goal8 = outFormat8.format(date8)

        Log.e(ContentValues.TAG,goal8)

        // day 10

        try {
            val myDate = inFormat.parse(date09)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date10 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date10)

        val inFormat9 = SimpleDateFormat("dd-MM-yyyy")
        val date9: Date? = inFormat9.parse(date10)
        val outFormat9 = SimpleDateFormat("EEEE")
        goal9 = outFormat9.format(date9)

        Log.e(ContentValues.TAG,goal9)

        // day 11

        try {
            val myDate = inFormat.parse(date10)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date11 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date11)

        val inFormat10 = SimpleDateFormat("dd-MM-yyyy")
        val dates10: Date? = inFormat10.parse(date11)
        val outFormat10 = SimpleDateFormat("EEEE")
        goal10 = outFormat10.format(dates10)

        Log.e(ContentValues.TAG,goal10)

        // day 12

        try {
            val myDate = inFormat.parse(date11)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date12 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date12)

        val inFormat11 = SimpleDateFormat("dd-MM-yyyy")
        val dates11: Date? = inFormat11.parse(date12)
        val outFormat11 = SimpleDateFormat("EEEE")
        goal11 = outFormat11.format(dates11)

        Log.e(ContentValues.TAG,goal11)

        // day 13

        try {
            val myDate = inFormat.parse(date12)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date13 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date13)

        val inFormat12 = SimpleDateFormat("dd-MM-yyyy")
        val dates12: Date? = inFormat12.parse(date13)
        val outFormat12 = SimpleDateFormat("EEEE")
        goal12 = outFormat12.format(dates12)

        Log.e(ContentValues.TAG,goal12)

        // day 14

        try {
            val myDate = inFormat.parse(date13)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date14 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date14)

        val inFormat13 = SimpleDateFormat("dd-MM-yyyy")
        val dates13: Date? = inFormat13.parse(date14)
        val outFormat13 = SimpleDateFormat("EEEE")
        goal13 = outFormat13.format(dates13)

        Log.e(ContentValues.TAG,goal13)

        // day 15

        try {
            val myDate = inFormat.parse(date14)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date15 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date15)

        val inFormat14 = SimpleDateFormat("dd-MM-yyyy")
        val dates14: Date? = inFormat14.parse(date15)
        val outFormat14 = SimpleDateFormat("EEEE")
        goal14 = outFormat14.format(dates14)

        Log.e(ContentValues.TAG,goal14)

        // day 16

        try {
            val myDate = inFormat.parse(date15)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date16 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date16)

        val inFormat15 = SimpleDateFormat("dd-MM-yyyy")
        val dates15: Date? = inFormat15.parse(date16)
        val outFormat15 = SimpleDateFormat("EEEE")
        goal15 = outFormat15.format(dates15)

        Log.e(ContentValues.TAG,goal15)

        // day 17

        try {
            val myDate = inFormat.parse(date16)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date17 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date17)

        val inFormat16 = SimpleDateFormat("dd-MM-yyyy")
        val dates16: Date? = inFormat16.parse(date17)
        val outFormat16 = SimpleDateFormat("EEEE")
        goal16 = outFormat16.format(dates16)

        Log.e(ContentValues.TAG,goal16)

        // day 18

        try {
            val myDate = inFormat.parse(date17)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date18 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date18)

        val inFormat17 = SimpleDateFormat("dd-MM-yyyy")
        val dates17: Date? = inFormat17.parse(date18)
        val outFormat17 = SimpleDateFormat("EEEE")
        goal17 = outFormat17.format(dates17)

        Log.e(ContentValues.TAG,goal17)

        // day 19

        try {
            val myDate = inFormat.parse(date18)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date19 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date19)

        val inFormat18 = SimpleDateFormat("dd-MM-yyyy")
        val dates18: Date? = inFormat18.parse(date19)
        val outFormat18 = SimpleDateFormat("EEEE")
        goal18 = outFormat18.format(dates18)

        Log.e(ContentValues.TAG,goal18)

        // day 20

        try {
            val myDate = inFormat.parse(date19)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date20 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date20)

        val inFormat19 = SimpleDateFormat("dd-MM-yyyy")
        val dates19: Date? = inFormat19.parse(date20)
        val outFormat19 = SimpleDateFormat("EEEE")
        goal19 = outFormat19.format(dates19)

        Log.e(ContentValues.TAG,goal19)

        // day 21

        try {
            val myDate = inFormat.parse(date20)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date21 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date21)

        val inFormat20 = SimpleDateFormat("dd-MM-yyyy")
        val dates20: Date? = inFormat20.parse(date21)
        val outFormat20 = SimpleDateFormat("EEEE")
        goal20 = outFormat20.format(dates20)

        Log.e(ContentValues.TAG,goal20)

        // day 22

        try {
            val myDate = inFormat.parse(date21)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date22 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date22)

        val inFormat21 = SimpleDateFormat("dd-MM-yyyy")
        val dates21: Date? = inFormat21.parse(date22)
        val outFormat21 = SimpleDateFormat("EEEE")
        goal21 = outFormat21.format(dates21)

        Log.e(ContentValues.TAG,goal21)



        // day 23

        try {
            val myDate = inFormat.parse(date22)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date23 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date23)

        val inFormat22 = SimpleDateFormat("dd-MM-yyyy")
        val dates22: Date? = inFormat22.parse(date23)
        val outFormat22 = SimpleDateFormat("EEEE")
        goal22 = outFormat22.format(dates22)

        Log.e(ContentValues.TAG,goal22)

        // day 24

        try {
            val myDate = inFormat.parse(date23)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date24 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date24)

        val inFormat23 = SimpleDateFormat("dd-MM-yyyy")
        val dates23: Date? = inFormat23.parse(date24)
        val outFormat23 = SimpleDateFormat("EEEE")
        goal23 = outFormat23.format(dates23)

        Log.e(ContentValues.TAG,goal23)

        // day 25

        try {
            val myDate = inFormat.parse(date24)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date25 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date25)

        val inFormat24 = SimpleDateFormat("dd-MM-yyyy")
        val dates24: Date? = inFormat24.parse(date25)
        val outFormat24 = SimpleDateFormat("EEEE")
        goal24 = outFormat24.format(dates24)

        Log.e(ContentValues.TAG,goal24)

        // day 26

        try {
            val myDate = inFormat.parse(date25)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date26 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date26)

        val inFormat25 = SimpleDateFormat("dd-MM-yyyy")
        val dates25: Date? = inFormat25.parse(date26)
        val outFormat25 = SimpleDateFormat("EEEE")
        goal25 = outFormat25.format(dates25)

        Log.e(ContentValues.TAG,goal25)

        // day 27

        try {
            val myDate = inFormat.parse(date26)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date27 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date27)

        val inFormat26 = SimpleDateFormat("dd-MM-yyyy")
        val dates26: Date? = inFormat26.parse(date27)
        val outFormat26 = SimpleDateFormat("EEEE")
        goal26 = outFormat26.format(dates26)

        Log.e(ContentValues.TAG,goal26)

        // day 28

        try {
            val myDate = inFormat.parse(date27)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date28 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date28)

        val inFormat27 = SimpleDateFormat("dd-MM-yyyy")
        val dates27: Date? = inFormat27.parse(date28)
        val outFormat27 = SimpleDateFormat("EEEE")
        goal27 = outFormat27.format(dates27)

        Log.e(ContentValues.TAG,goal27)

        // day 29

        try {
            val myDate = inFormat.parse(date28)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date29 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date29)

        val inFormat28 = SimpleDateFormat("dd-MM-yyyy")
        val dates28: Date? = inFormat28.parse(date29)
        val outFormat28 = SimpleDateFormat("EEEE")
        goal28 = outFormat28.format(dates28)

        Log.e(ContentValues.TAG,goal28)

        // day 30

        try {
            val myDate = inFormat.parse(date29)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date30 = inFormat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date30)

        val inFormat29 = SimpleDateFormat("dd-MM-yyyy")
        val dates29: Date? = inFormat29.parse(date30)
        val outFormat29 = SimpleDateFormat("EEEE")
        goal29 = outFormat29.format(dates29)

        Log.e(ContentValues.TAG,goal29)



        val zonesRef = FirebaseDatabase.getInstance().getReference("datewisebookings").child(uid)


        zonesRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (zoneSnapshot in dataSnapshot.children) {

                    {
                        val date = arrayOf(zoneSnapshot.child("ddate").getValue(String::class.java).toString())

                        Log.e(TAG, date[1])
                    }





                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })





        setValuesToViews()

        val apart1 = tvApartmentSize.text.toString()
        if (apart1.equals("4BHK") || apart1.equals("5BHK") || apart1.equals("6BHK"))
        {

            maid2tv.visibility = View.VISIBLE
            allotedmaid2tv.visibility = View.VISIBLE
        }

        btnAllot.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("uid").toString()
            )
        }



    }

    private fun openUpdateDialog(uid: String) {

        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.allocate_maid, null)

        mDialog.setView(mDialogView)

        val etStartDate = mDialogView.findViewById<EditText>(R.id.startingdateed)
        val etApartmentSize = mDialogView.findViewById<EditText>(R.id.apartmentsizeed)
        val etFreequency = mDialogView.findViewById<EditText>(R.id.freequencyed)
        val etDays = mDialogView.findViewById<EditText>(R.id.daysed)
        val etShift = mDialogView.findViewById<EditText>(R.id.shifted)
        val etMaid = mDialogView.findViewById<Spinner>(R.id.maidname)
        val selectmaid1 = mDialogView.findViewById<TextView>(R.id.maid2)
        val etMaid1 = mDialogView.findViewById<Spinner>(R.id.maidname1)





        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)

        etStartDate.setText(intent.getStringExtra("startdate").toString())
        etApartmentSize.setText(intent.getStringExtra("apartmentsize").toString())
        etFreequency.setText(intent.getStringExtra("freequency").toString())
        etDays.setText(intent.getStringExtra("days").toString())
        etShift.setText(intent.getStringExtra("shift").toString())

        val apart = etApartmentSize.text.toString()

        etStartDate.isEnabled = false
        etStartDate.isFocusable = false
        etApartmentSize.isEnabled = false
        etApartmentSize.isFocusable = false
        etFreequency.isEnabled = false
        etFreequency.isFocusable = false
        etDays.isEnabled = false
        etDays.isFocusable = false
        etShift.isEnabled = false
        etShift.isFocusable = false
        Log.e(TAG,apart)


        if (apart.equals("4BHK") || apart.equals("5BHK") || apart.equals("6BHK")) {

            selectmaid1.visibility = View.VISIBLE
            etMaid1.visibility = View.VISIBLE

            val dataref = FirebaseDatabase.getInstance().getReference()

            dataref.child("maids").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(mdataSnapshot: DataSnapshot) {
                    // Is better to use a List, because you don't know the size
                    // of the iterator returned by dataSnapshot.getChildren() to
                    // initialize the array
                    val maids: MutableList<String> = ArrayList()
                    for (addressSnapshot in mdataSnapshot.children) {
                        propertyAddress = addressSnapshot.child("firstname").getValue(
                            String::class.java
                        )!!

                        if (propertyAddress != null) {
                            maids.add(propertyAddress)
                        }


                    }

                    val addressAdapter = ArrayAdapter(
                        this@AdminViewBookings,
                        android.R.layout.simple_spinner_dropdown_item,
                        maids
                    )
                    addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    etMaid.adapter = addressAdapter


                    etMaid.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            selected = maids[p2].toString()

                            if (propertyAddress.equals(selected)) {
                                key = mdataSnapshot.child(selected).getKey()
                                    .toString(); //This will return -LoUXnfUCEj4k4A3dkte
                            }

                            val bookref = FirebaseDatabase.getInstance().getReference("maids")


                            bookref.addValueEventListener(object : ValueEventListener {

                                override fun onDataChange(msnapshot: DataSnapshot) {
                                    for (msnapshot in mdataSnapshot.children) {
                                        if (msnapshot.child("firstname")
                                                .getValue(String::class.java) == selected
                                        ) {
                                            key = msnapshot.key.toString()
                                        }
                                        keyholder = mdataSnapshot.child(key).child("maidid")
                                            .getValue(String::class.java).toString()


                                    }
                                    allotedMiad = keyholder

                                }


                                override fun onCancelled(error: DatabaseError) {
                                    TODO("Not yet implemented")
                                }
                            });

                        }


                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })


            val dataref1 = FirebaseDatabase.getInstance().getReference()

            dataref1.child("maids").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // Is better to use a List, because you don't know the size
                    // of the iterator returned by dataSnapshot.getChildren() to
                    // initialize the array
                    val maids: MutableList<String> = ArrayList()
                    for (addressSnapshot in dataSnapshot.children) {
                        propertyAddress1 = addressSnapshot.child("firstname").getValue(
                            String::class.java
                        )!!

                        if (propertyAddress1 != null) {
                            maids.add(propertyAddress1)
                        }


                    }

                    val addressAdapter = ArrayAdapter(
                        this@AdminViewBookings,
                        android.R.layout.simple_spinner_dropdown_item,
                        maids
                    )
                    addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    etMaid1.adapter = addressAdapter


                    etMaid1.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            selected1 = maids[p2].toString()

                            if (propertyAddress1.equals(selected1)) {
                                key1 = dataSnapshot.child(selected1).getKey()
                                    .toString(); //This will return -LoUXnfUCEj4k4A3dkte
                            }

                            val bookref1 = FirebaseDatabase.getInstance().getReference("maids")


                            bookref1.addValueEventListener(object : ValueEventListener {

                                override fun onDataChange(snapshot: DataSnapshot) {
                                    for (snapshot in dataSnapshot.children) {
                                        if (snapshot.child("firstname")
                                                .getValue(String::class.java) == selected1
                                        ) {
                                            key1 = snapshot.key.toString()
                                        }
                                        keyholder1 = dataSnapshot.child(key1).child("maidid")
                                            .getValue(String::class.java).toString()


                                    }
                                    allotedMiad1 = keyholder1

                                }


                                override fun onCancelled(error: DatabaseError) {
                                    TODO("Not yet implemented")
                                }
                            });

                        }


                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }
        else{

            selected1 = " "
            allotedMiad1 = " "

            val dataref = FirebaseDatabase.getInstance().getReference()

            dataref.child("maids").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(mdataSnapshot: DataSnapshot) {
                    // Is better to use a List, because you don't know the size
                    // of the iterator returned by dataSnapshot.getChildren() to
                    // initialize the array
                    val maids: MutableList<String> = ArrayList()
                    for (addressSnapshot in mdataSnapshot.children) {
                        propertyAddress = addressSnapshot.child("firstname").getValue(
                            String::class.java
                        )!!

                        if (propertyAddress != null) {
                            maids.add(propertyAddress)
                        }


                    }

                    val addressAdapter = ArrayAdapter(
                        this@AdminViewBookings,
                        android.R.layout.simple_spinner_dropdown_item,
                        maids
                    )
                    addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    etMaid.adapter = addressAdapter


                    etMaid.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            selected = maids[p2].toString()

                            if (propertyAddress.equals(selected)) {
                                key = mdataSnapshot.child(selected).getKey()
                                    .toString(); //This will return -LoUXnfUCEj4k4A3dkte
                            }

                            val bookref = FirebaseDatabase.getInstance().getReference("maids")


                            bookref.addValueEventListener(object : ValueEventListener {

                                override fun onDataChange(msnapshot: DataSnapshot) {
                                    for (msnapshot in mdataSnapshot.children) {
                                        if (msnapshot.child("firstname")
                                                .getValue(String::class.java) == selected
                                        ) {
                                            key = msnapshot.key.toString()
                                        }
                                        keyholder = mdataSnapshot.child(key).child("maidid")
                                            .getValue(String::class.java).toString()


                                    }
                                    allotedMiad = keyholder

                                }


                                override fun onCancelled(error: DatabaseError) {
                                    TODO("Not yet implemented")
                                }
                            });

                        }


                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        }






            mDialog.setTitle("Allocate Maid")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {
            updateBookingData(
                etStartDate.text.toString(),
                etApartmentSize.text.toString(),
                etFreequency.text.toString(),
                etDays.text.toString(),
                etShift.text.toString(),
                selected,
                allotedMiad,
                selected1,
                allotedMiad1,
                nodays,
                uid
            )

            val ref = FirebaseDatabase.getInstance().getReference("datewisebookings")
            updateDateWiseBookingDate()
            updateDateWiseBookingDate1()
            updateDateWiseBookingDate2()
            updateDateWiseBookingDate3()
            updateDateWiseBookingDate4()
            updateDateWiseBookingDate5()
            updateDateWiseBookingDate6()
            updateDateWiseBookingDate7()
            updateDateWiseBookingDate8()
            updateDateWiseBookingDate9()
            updateDateWiseBookingDate10()
            updateDateWiseBookingDate11()
            updateDateWiseBookingDate12()
            updateDateWiseBookingDate13()
            updateDateWiseBookingDate14()
            updateDateWiseBookingDate15()
            updateDateWiseBookingDate16()
            updateDateWiseBookingDate17()
            updateDateWiseBookingDate18()
            updateDateWiseBookingDate19()
            updateDateWiseBookingDate20()
            updateDateWiseBookingDate21()
            updateDateWiseBookingDate22()
            updateDateWiseBookingDate23()
            updateDateWiseBookingDate24()
            updateDateWiseBookingDate25()
            updateDateWiseBookingDate26()
            updateDateWiseBookingDate27()
            updateDateWiseBookingDate28()
            updateDateWiseBookingDate29()


            Toast.makeText(applicationContext, "Maid Allocated Successfully", Toast.LENGTH_LONG).show()


            alertDialog.dismiss()

            allotedmaid2tv.text = selected1
            tvAllotedMaid.text = selected

        }

    }

    private fun updateDateWiseBookingDate29() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date30 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun updateDateWiseBookingDate28() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date29 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate27() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date28 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate26() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date27 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate25() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date26 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate24() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date25 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate23() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date24 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate22() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date23 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate21() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date22 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate20() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date21 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate19() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date20 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate18() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date19 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate17() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date18 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate16() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date17 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }

    private fun updateDateWiseBookingDate15() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date16 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate14() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date15 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate13() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date14 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate12() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date13 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate11() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date12 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate10() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date11 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate9() {



        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date10 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun updateDateWiseBookingDate8() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date09 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun updateDateWiseBookingDate7() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date08 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun updateDateWiseBookingDate6() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date07 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun updateDateWiseBookingDate5() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date06 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun updateDateWiseBookingDate4() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date05 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun updateDateWiseBookingDate3() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date04 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun updateDateWiseBookingDate2() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date03 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun updateDateWiseBookingDate1() {
        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(date02 + fullname)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun updateDateWiseBookingDate() {

        val ref = FirebaseDatabase.getInstance().getReference("datewisebookings").child(startdate + fullname)
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    ref.child("dmaid").setValue(selected)
                    ref.child("dmaid2").setValue(selected1)
                    ref.child("dmaidid").setValue(allotedMiad)
                    ref.child("dmaidid2").setValue(allotedMiad1)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }










    private fun updateBookingData(
        startdate: String,
        apartmentsize: String,
        freequency: String,
        days: String,
        shift: String,
        allocatedMaid: String,
        allotedMaidId: String,
        allocatedMaid1: String,
        allotedMaidId1: String,
        noofdays: String,
        uid: String
    ) {
        val dbRef1 = FirebaseDatabase.getInstance().getReference("bookings").child(uid)
        val maidInfo = Bookings(startdate, apartmentsize, freequency, days, shift, allocatedMaid,allotedMaidId,allocatedMaid1,allotedMaidId1, noofdays, uid)
        dbRef1.setValue(maidInfo)


    }

    private fun setValuesToViews() {

        tvStartDate.text = intent.getStringExtra("startdate")
        tvApartmentSize.text = intent.getStringExtra("apartmentsize")
        tvFreequency.text = intent.getStringExtra("freequency")
        tvDays.text = intent.getStringExtra("days")
        tvConvinientTime.text = intent.getStringExtra("shift")
        tvAllotedMaid.text = intent.getStringExtra("allocatedMaid")
        allotedmaid2tv.text = intent.getStringExtra("allocatedMaid1")
        nodays = intent.getStringExtra("noofdays").toString()



    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, AdminHome::class.java)
        startActivity(intent)
        finish()
    }


}
