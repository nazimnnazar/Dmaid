package com.example.dmaid

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.Home
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class CustomerDashBoard1 : AppCompatActivity() {

private lateinit var startdate: String
    private lateinit var firebaseauth: FirebaseAuth


    lateinit var date01 : Date
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


    var ndate01 = ""
    var ndate02 = ""
    var ndate03 = ""
    var ndate04 = ""
    var ndate05 = ""
    var ndate06 = ""
    var ndate07 = ""
    var ndate08 = ""
    var ndate09 = ""
    var ndate10 = ""
    var ndate11 = ""
    var ndate12 = ""
    var ndate13 = ""
    var ndate14 = ""
    var ndate15 = ""
    var ndate16 = ""
    var ndate17 = ""
    var ndate18 = ""
    var ndate19 = ""
    var ndate20 = ""
    var ndate21 = ""
    var ndate22 = ""
    var ndate23 = ""
    var ndate24 = ""
    var ndate25 = ""
    var ndate26 = ""
    var ndate27 = ""
    var ndate28 = ""
    var ndate29 = ""
    var ndate30 = ""


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

    private lateinit var day1: TextView
    private lateinit var day2: TextView
    private lateinit var day3: TextView
    private lateinit var day4: TextView
    private lateinit var day5: TextView
    private lateinit var day6: TextView
    private lateinit var day7: TextView
    private lateinit var day8: TextView
    private lateinit var day9: TextView
    private lateinit var day10: TextView
    private lateinit var day11: TextView
    private lateinit var day12: TextView
    private lateinit var day13: TextView
    private lateinit var day14: TextView
    private lateinit var day15: TextView
    private lateinit var day16: TextView
    private lateinit var day17: TextView
    private lateinit var day18: TextView
    private lateinit var day19: TextView
    private lateinit var day20: TextView
    private lateinit var day21: TextView
    private lateinit var day22: TextView
    private lateinit var day23: TextView
    private lateinit var day24: TextView
    private lateinit var day25: TextView
    private lateinit var day26: TextView
    private lateinit var day27: TextView
    private lateinit var day28: TextView
    private lateinit var day29: TextView
    private lateinit var day30: TextView
    private lateinit var day31: TextView
    private lateinit var day32: TextView
    private lateinit var day33: TextView
    private lateinit var day34: TextView
    private lateinit var day35: TextView

    private lateinit var smonth: TextView
    private lateinit var emonth: TextView


    private lateinit var firstname : String
    private lateinit var lastname : String
    private lateinit var fullname : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_dash_board1)

        day1 = findViewById(R.id.day1)
        day2 = findViewById(R.id.day2)
        day3 = findViewById(R.id.day3)
        day4 = findViewById(R.id.day4)
        day5 = findViewById(R.id.day5)
        day6 = findViewById(R.id.day6)
        day7 = findViewById(R.id.day7)
        day8 = findViewById(R.id.day8)
        day9 = findViewById(R.id.day9)
        day10 = findViewById(R.id.day10)
        day11 = findViewById(R.id.day11)
        day12 = findViewById(R.id.day12)
        day13 = findViewById(R.id.day13)
        day14 = findViewById(R.id.day14)
        day15 = findViewById(R.id.day15)
        day16 = findViewById(R.id.day16)
        day17 = findViewById(R.id.day17)
        day18 = findViewById(R.id.day18)
        day19 = findViewById(R.id.day19)
        day20 = findViewById(R.id.day20)
        day21 = findViewById(R.id.day21)
        day22 = findViewById(R.id.day22)
        day23 = findViewById(R.id.day23)
        day24 = findViewById(R.id.day24)
        day25 = findViewById(R.id.day25)
        day26 = findViewById(R.id.day26)
        day27 = findViewById(R.id.day27)
        day28 = findViewById(R.id.day28)
        day29 = findViewById(R.id.day29)
        day30 = findViewById(R.id.day30)

        smonth = findViewById(R.id.month1)
        emonth = findViewById(R.id.month2)


        firebaseauth = FirebaseAuth.getInstance()
        val uid = firebaseauth.currentUser!!.uid


        val sstartdate = intent.getStringExtra("startdate")!!
        firstname = intent.getStringExtra("firstname")!!
        lastname = intent.getStringExtra("lastname")!!
        fullname = intent.getStringExtra("fullname")!!

        startdate= getMondayDate(sstartdate)
       // val daysToMonday = (sstartdate.toInt() - Calendar.MONDAY + 7) % 7

        //Toast.makeText(this@CustomerDashBoard1,daysToMonday.toString(), Toast.LENGTH_SHORT).show()


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

        val inf0 = SimpleDateFormat("dd-MM-yyyy")
        val dd0: Date? = inf0.parse(startdate)
        val outf0 = SimpleDateFormat("dd")
        val mm0 = outf0.format(dd0)
        day1.text = mm0

        val bookingsRef = FirebaseDatabase.getInstance().getReference("datewisebookings")
        val bookings1Ref = bookingsRef.child(startdate + fullname)

        bookings1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day1.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day1.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day1.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })

        val inf = SimpleDateFormat("dd-MM-yyyy")
        val dd: Date? = inf.parse(date02)
        val outf = SimpleDateFormat("dd")
        val mm = outf.format(dd)
        day2.text = mm


        val day21Ref = bookingsRef.child(date02 + fullname)

        day21Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day2.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day2.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day2.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf1 = SimpleDateFormat("dd-MM-yyyy")
        val dd1: Date? = inf1.parse(date03)
        val outf1 = SimpleDateFormat("dd")
        val mm1 = outf1.format(dd1)
        day3.text = mm1

        val day31Ref = bookingsRef.child(date03 + fullname)

        day31Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day3.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day3.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day3.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })

        val inf2 = SimpleDateFormat("dd-MM-yyyy")
        val dd2: Date? = inf2.parse(date04)
        val outf2 = SimpleDateFormat("dd")
        val mm2 = outf2.format(dd2)
        day4.text = mm2

        val day41Ref = bookingsRef.child(date04 + fullname)

        day41Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day4.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day4.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day4.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf3 = SimpleDateFormat("dd-MM-yyyy")
        val dd3: Date? = inf3.parse(date05)
        val outf3 = SimpleDateFormat("dd")
        val mm3 = outf3.format(dd3)
        day5.text = mm3

        val day51Ref = bookingsRef.child(date05 + fullname)

        day51Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day5.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day5.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day5.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf4 = SimpleDateFormat("dd-MM-yyyy")
        val dd4: Date? = inf4.parse(date06)
        val outf4 = SimpleDateFormat("dd")
        val mm4 = outf4.format(dd4)
        day6.text = mm4

        val day61Ref = bookingsRef.child(date06 + fullname)

        day61Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day6.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day6.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day6.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf5 = SimpleDateFormat("dd-MM-yyyy")
        val dd5: Date? = inf5.parse(date07)
        val outf5 = SimpleDateFormat("dd")
        val mm5 = outf5.format(dd5)
        day7.text = mm5

        val day71Ref = bookingsRef.child(date07 + fullname)

        day71Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day7.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day7.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day7.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf6 = SimpleDateFormat("dd-MM-yyyy")
        val dd6: Date? = inf6.parse(date08)
        val outf6 = SimpleDateFormat("dd")
        val mm6 = outf6.format(dd6)
        day8.text = mm6

        val day81Ref = bookingsRef.child(date08 + fullname)

        day81Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day8.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day8.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day8.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf7 = SimpleDateFormat("dd-MM-yyyy")
        val dd7: Date? = inf7.parse(date09)
        val outf7 = SimpleDateFormat("dd")
        val mm7 = outf7.format(dd7)
        day9.text = mm7

        val day91Ref = bookingsRef.child(date09 + fullname)

        day91Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day9.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day9.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day9.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf8 = SimpleDateFormat("dd-MM-yyyy")
        val dd8: Date? = inf8.parse(date10)
        val outf8 = SimpleDateFormat("dd")
        val mm8 = outf8.format(dd8)
        day10.text = mm8

        val day101Ref = bookingsRef.child(date10 + fullname)

        day101Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day10.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day10.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day10.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf9 = SimpleDateFormat("dd-MM-yyyy")
        val dd9: Date? = inf9.parse(date11)
        val outf9 = SimpleDateFormat("dd")
        val mm9 = outf9.format(dd9)
        day11.text = mm9

        val day111Ref = bookingsRef.child(date11 + fullname)

        day111Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day11.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day11.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day11.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf10 = SimpleDateFormat("dd-MM-yyyy")
        val dd10: Date? = inf10.parse(date12)
        val outf10 = SimpleDateFormat("dd")
        val mm10 = outf10.format(dd10)
        day12.text = mm10

        val day121Ref = bookingsRef.child(date12 + fullname)

        day121Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day12.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day12.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day12.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf11 = SimpleDateFormat("dd-MM-yyyy")
        val dd11: Date? = inf11.parse(date13)
        val outf11 = SimpleDateFormat("dd")
        val mm11 = outf11.format(dd11)
        day13.text = mm11

        val day131Ref = bookingsRef.child(date13 + fullname)

        day131Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day13.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day13.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day13.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf12 = SimpleDateFormat("dd-MM-yyyy")
        val dd12: Date? = inf12.parse(date14)
        val outf12 = SimpleDateFormat("dd")
        val mm12 = outf12.format(dd12)
        day14.text = mm12

        val day141Ref = bookingsRef.child(date14 + fullname)

        day141Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day14.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day14.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day14.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf13 = SimpleDateFormat("dd-MM-yyyy")
        val dd13: Date? = inf13.parse(date15)
        val outf13 = SimpleDateFormat("dd")
        val mm13 = outf13.format(dd13)
        day15.text = mm13

        val day151Ref = bookingsRef.child(date15 + fullname)

        day151Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day15.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day15.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day15.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf14 = SimpleDateFormat("dd-MM-yyyy")
        val dd14: Date? = inf14.parse(date16)
        val outf14 = SimpleDateFormat("dd")
        val mm14 = outf14.format(dd14)
        day16.text = mm14

        val day161Ref = bookingsRef.child(date16 + fullname)

        day161Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day16.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day16.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day16.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf15 = SimpleDateFormat("dd-MM-yyyy")
        val dd15: Date? = inf15.parse(date17)
        val outf15 = SimpleDateFormat("dd")
        val mm15 = outf15.format(dd15)
        day17.text = mm15

        val day171Ref = bookingsRef.child(date17 + fullname)

        day171Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day17.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day17.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day17.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf16 = SimpleDateFormat("dd-MM-yyyy")
        val dd16: Date? = inf16.parse(date18)
        val outf16 = SimpleDateFormat("dd")
        val mm16 = outf16.format(dd16)
        day18.text = mm16

        val day181Ref = bookingsRef.child(date18 + fullname)

        day181Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day18.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day18.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day18.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf17 = SimpleDateFormat("dd-MM-yyyy")
        val dd17: Date? = inf17.parse(date19)
        val outf17 = SimpleDateFormat("dd")
        val mm17 = outf17.format(dd17)
        day19.text = mm17

        val day191Ref = bookingsRef.child(date19 + fullname)

        day191Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day19.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day19.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day19.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf18 = SimpleDateFormat("dd-MM-yyyy")
        val dd18: Date? = inf18.parse(date20)
        val outf18 = SimpleDateFormat("dd")
        val mm18 = outf18.format(dd18)
        day20.text = mm18

        val day201Ref = bookingsRef.child(date20 + fullname)

        day201Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day20.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day20.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day20.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf19 = SimpleDateFormat("dd-MM-yyyy")
        val dd19: Date? = inf19.parse(date21)
        val outf19 = SimpleDateFormat("dd")
        val mm19 = outf19.format(dd19)
        day21.text = mm19

        val day211Ref = bookingsRef.child(date21 + fullname)

        day211Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day21.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day21.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day21.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf20 = SimpleDateFormat("dd-MM-yyyy")
        val dd20: Date? = inf20.parse(date22)
        val outf20 = SimpleDateFormat("dd")
        val mm20 = outf20.format(dd20)
        day22.text = mm20

        val day221Ref = bookingsRef.child(date22 + fullname)

        day221Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day22.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day22.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day22.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf21 = SimpleDateFormat("dd-MM-yyyy")
        val dd21: Date? = inf21.parse(date22)
        val outf21 = SimpleDateFormat("dd")
        val mm21 = outf21.format(dd21)
        day23.text = mm21

        val day231Ref = bookingsRef.child(date23 + fullname)

        day231Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day23.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day23.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day23.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf22 = SimpleDateFormat("dd-MM-yyyy")
        val dd22: Date? = inf22.parse(date24)
        val outf22 = SimpleDateFormat("dd")
        val mm22 = outf22.format(dd22)
        day24.text = mm22

        val day241Ref = bookingsRef.child(date24 + fullname)

        day241Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day24.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day24.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day24.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf23 = SimpleDateFormat("dd-MM-yyyy")
        val dd23: Date? = inf23.parse(date25)
        val outf23 = SimpleDateFormat("dd")
        val mm23 = outf23.format(dd23)
        day25.text = mm23

        val day251Ref = bookingsRef.child(date25 + fullname)

        day251Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day25.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day25.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day25.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf24 = SimpleDateFormat("dd-MM-yyyy")
        val dd24: Date? = inf24.parse(date26)
        val outf24 = SimpleDateFormat("dd")
        val mm24 = outf24.format(dd24)
        day26.text = mm24

        val day261Ref = bookingsRef.child(date26 + fullname)

        day261Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day26.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day26.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day26.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf25 = SimpleDateFormat("dd-MM-yyyy")
        val dd25: Date? = inf25.parse(date27)
        val outf25 = SimpleDateFormat("dd")
        val mm25 = outf25.format(dd25)
        day27.text = mm25

        val day271Ref = bookingsRef.child(date27 + fullname)

        day271Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day27.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day27.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day27.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf26 = SimpleDateFormat("dd-MM-yyyy")
        val dd26: Date? = inf26.parse(date28)
        val outf26 = SimpleDateFormat("dd")
        val mm26 = outf26.format(dd26)
        day28.text = mm26

        val day281Ref = bookingsRef.child(date28 + fullname)

        day281Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day28.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day28.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day28.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf27 = SimpleDateFormat("dd-MM-yyyy")
        val dd27: Date? = inf27.parse(date29)
        val outf27 = SimpleDateFormat("dd")
        val mm27 = outf27.format(dd27)
        day29.text = mm27

        val day291Ref = bookingsRef.child(date29 + fullname)

        day291Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day29.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day29.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day29.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })
        val inf28 = SimpleDateFormat("dd-MM-yyyy")
        val dd28: Date? = inf28.parse(date30)
        val outf28 = SimpleDateFormat("dd")
        val mm28 = outf28.format(dd28)
        day30.text = mm28

        val day301Ref = bookingsRef.child(date30 + fullname)

        day301Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val day1s = dataSnapshot.child("dstatus").getValue(String::class.java)
                if (day1s.equals("Pending"))
                {

                    day30.setBackgroundResource(R.drawable.pending_textview)
                }
                else if (day1s.equals("Completed")){
                    day30.setBackgroundResource(R.drawable.completed_textview)
                }
                else{
                    day30.setBackgroundResource(R.drawable.leave_textview)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })

        val inf001 = SimpleDateFormat("dd-MM-yyyy")
        val dd001: Date? = inf001.parse(startdate)
        val outf001 = SimpleDateFormat("MMMM")
        val mm001 = outf001.format(dd001)
        smonth.text = mm001


        val inf002 = SimpleDateFormat("dd-MM-yyyy")
        val dd002: Date? = inf002.parse(date30)
        val outf002 = SimpleDateFormat("MMMM")
        val mm002 = outf002.format(dd002)
        emonth.text = mm002
    }
    fun getMondayDate(inputDate: String): String {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val calendar = Calendar.getInstance()

        try {
            // Parse the input date string to a Date object
            val date = dateFormat.parse(inputDate)

            // Set the calendar to the input date
            calendar.time = date

            // Set the calendar to the previous Monday
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)

            // Get the date of the Monday
            val mondayDate = calendar.time

           // val daysToMonday = (dayOfWeek - Calendar.MONDAY + 7) % 7

            // Format the Monday date to the desired format
            return dateFormat.format(mondayDate)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }
}