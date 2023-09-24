package com.example.dmaid

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.AdminHome
import com.example.dmaid.Activity.Home
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class CustomerDashboard : AppCompatActivity() {

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


    var date01 = ""
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_dashboard)



        val inFormat = SimpleDateFormat("dd-MM-yyyy")
        val format1 = SimpleDateFormat("dd")

        val dat = "01-12-2022"
        try {
            val myDate = inFormat.parse(dat)
            val c = Calendar.getInstance()
            c.time = myDate
            val newDate = c.time
           date01 = inFormat.format(newDate)
            val date1: Date? = inFormat.parse(date01)
            val outFormat = SimpleDateFormat("EEEE")
            goal = outFormat.format(date1)

        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }
        Log.e(ContentValues.TAG,date01)
        Log.e(ContentValues.TAG,goal)

        // day 2

        try {
            val myDate = inFormat.parse(dat)
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
        val date10: Date? = inFormat10.parse(date11)
        val outFormat10 = SimpleDateFormat("EEEE")
        goal10 = outFormat10.format(date10)

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
        val date11: Date? = inFormat11.parse(date12)
        val outFormat11 = SimpleDateFormat("EEEE")
        goal11 = outFormat11.format(date11)

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
        val date12: Date? = inFormat12.parse(date13)
        val outFormat12 = SimpleDateFormat("EEEE")
        goal12 = outFormat12.format(date12)

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
        val date13: Date? = inFormat13.parse(date14)
        val outFormat13 = SimpleDateFormat("EEEE")
        goal13 = outFormat13.format(date13)

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
        val date14: Date? = inFormat14.parse(date15)
        val outFormat14 = SimpleDateFormat("EEEE")
        goal14 = outFormat14.format(date14)

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
        val date15: Date? = inFormat15.parse(date16)
        val outFormat15 = SimpleDateFormat("EEEE")
        goal15 = outFormat15.format(date15)

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
        val date16: Date? = inFormat16.parse(date17)
        val outFormat16 = SimpleDateFormat("EEEE")
        goal16 = outFormat16.format(date16)

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
        val date17: Date? = inFormat17.parse(date18)
        val outFormat17 = SimpleDateFormat("EEEE")
        goal17 = outFormat17.format(date17)

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
        val date18: Date? = inFormat18.parse(date19)
        val outFormat18 = SimpleDateFormat("EEEE")
        goal18 = outFormat18.format(date18)

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
        val date19: Date? = inFormat19.parse(date20)
        val outFormat19 = SimpleDateFormat("EEEE")
        goal19 = outFormat19.format(date19)

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
        val date20: Date? = inFormat20.parse(date21)
        val outFormat20 = SimpleDateFormat("EEEE")
        goal20 = outFormat20.format(date20)

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
        val date21: Date? = inFormat21.parse(date22)
        val outFormat21 = SimpleDateFormat("EEEE")
        goal21 = outFormat21.format(date21)

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
        val date22: Date? = inFormat22.parse(date23)
        val outFormat22 = SimpleDateFormat("EEEE")
        goal22 = outFormat22.format(date22)

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
        val date23: Date? = inFormat23.parse(date24)
        val outFormat23 = SimpleDateFormat("EEEE")
        goal23 = outFormat23.format(date23)

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
        val date24: Date? = inFormat24.parse(date25)
        val outFormat24 = SimpleDateFormat("EEEE")
        goal24 = outFormat24.format(date24)

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
        val date25: Date? = inFormat25.parse(date26)
        val outFormat25 = SimpleDateFormat("EEEE")
        goal25 = outFormat25.format(date25)

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
        val date26: Date? = inFormat26.parse(date27)
        val outFormat26 = SimpleDateFormat("EEEE")
        goal26 = outFormat26.format(date26)

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
        val date27: Date? = inFormat27.parse(date28)
        val outFormat27 = SimpleDateFormat("EEEE")
        goal27 = outFormat27.format(date27)

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
        val date28: Date? = inFormat28.parse(date29)
        val outFormat28 = SimpleDateFormat("EEEE")
        goal28 = outFormat28.format(date28)

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
        val date29: Date? = inFormat29.parse(date30)
        val outFormat29 = SimpleDateFormat("EEEE")
        goal29 = outFormat29.format(date29)

        Log.e(ContentValues.TAG,goal29)

        day1 = findViewById(R.id.date1)
        day2 = findViewById(R.id.date2)
        day3 = findViewById(R.id.date3)
        day4 = findViewById(R.id.date4)
        day5 = findViewById(R.id.date5)
        day6 = findViewById(R.id.date6)
        day7 = findViewById(R.id.date7)
        day8 = findViewById(R.id.date8)
        day9 = findViewById(R.id.date9)
        day10 = findViewById(R.id.date10)
        day11 = findViewById(R.id.date11)
        day12 = findViewById(R.id.date12)
        day13 = findViewById(R.id.date13)
        day14 = findViewById(R.id.date14)
        day15 = findViewById(R.id.date15)
        day16 = findViewById(R.id.date16)
        day17 = findViewById(R.id.date17)
        day18 = findViewById(R.id.date18)
        day19 = findViewById(R.id.date19)
        day20 = findViewById(R.id.date20)
        day21 = findViewById(R.id.date21)
        day22 = findViewById(R.id.date22)
        day23 = findViewById(R.id.date23)
        day24 = findViewById(R.id.date24)
        day25 = findViewById(R.id.date25)
        day26 = findViewById(R.id.date26)
        day27 = findViewById(R.id.date27)
        day28 = findViewById(R.id.date28)
        day29 = findViewById(R.id.date29)
        day30 = findViewById(R.id.date30)
        day31 = findViewById(R.id.date31)
        day32 = findViewById(R.id.date32)
        day33 = findViewById(R.id.date33)
        day34 = findViewById(R.id.date34)
        day35 = findViewById(R.id.date35)


        if (goal == "Sunday")
        {
            if(day1.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day1.text = goal1
            }
            else if (day8.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day8.text = goal1
            }
            else if (day15.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day15.text = goal1
            }
            else if (day22.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day22.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day29.text = goal1
            }
        }
        else if (goal == "Monday")
        {
            day1.text = "--"
            if(day2.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day2.text = goal1
            }
            else if (day9.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day9.text = goal1
            }
            else if (day16.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day16.text = goal1
            }
            else if (day23.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day23.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day30.text = goal1
            }
        }
        else if (goal == "Tuesday")
        {
            day2.text = "--"
            if(day3.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day3.text = goal1
            }
            else if (day10.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day10.text = goal1
            }
            else if (day17.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day17.text = goal1
            }
            else if (day24.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day24.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day31.text = goal1
            }
        }
        else if (goal == "Wednesday")
        {
            if(day4.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day4.text = goal1
            }
            else if (day11.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day11.text = goal1
            }
            else if (day18.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day18.text = goal1
            }
            else if (day25.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day25.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day32.text = goal1
            }
        }
        else if (goal == "Thursday")
        {
            if(day5.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day5.text = goal1
            }
            else if (day12.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day12.text = goal1
            }
            else if (day19.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day19.text = goal1
            }
            else if (day26.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day26.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day33.text = goal1
            }
        }
        else if (goal == "Friday")
        {
            if(day6.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day6.text = goal1
            }
            else if (day13.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day13.text = goal1
            }
            else if (day20.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day20.text = goal1
            }
            else if (day27.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day27.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day34.text = goal1
            }
        }
        else if (goal == "Saturday")
        {
            if(day7.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day7.text = goal1
            }
            else if (day14.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day14.text = goal1
            }
            else if (day21.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day21.text = goal1
            }
            else if (day28.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day28.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day35.text = goal1
            }
        }

        // date 2

        if (goal1 == "Sunday")
        {
            if(day1.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day1.text = goal1
            }
            else if (day8.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day8.text = goal1
            }
            else if (day15.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day15.text = goal1
            }
            else if (day22.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day22.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day29.text = goal1
            }
        }
        else if (goal1 == "Monday")
        {
            if(day2.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day2.text = goal1
            }
            else if (day9.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day9.text = goal1
            }
            else if (day16.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day16.text = goal1
            }
            else if (day23.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day23.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day30.text = goal1
            }
        }
        else if (goal1 == "Tuesday")
        {
            if(day3.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day3.text = goal1
            }
            else if (day10.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day10.text = goal1
            }
            else if (day17.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day17.text = goal1
            }
            else if (day24.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day24.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day31.text = goal1
            }
        }
        else if (goal1 == "Wednesday")
        {
            if(day4.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day4.text = goal1
            }
            else if (day11.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day11.text = goal1
            }
            else if (day18.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day18.text = goal1
            }
            else if (day25.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day25.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day32.text = goal1
            }
        }
        else if (goal1 == "Thursday")
        {
            if(day5.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day5.text = goal1
            }
            else if (day12.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day12.text = goal1
            }
            else if (day19.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day19.text = goal1
            }
            else if (day26.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day26.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day33.text = goal1
            }
        }
        else if (goal1 == "Friday")
        {
            if(day6.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day6.text = goal1
            }
            else if (day13.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day13.text = goal1
            }
            else if (day20.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day20.text = goal1
            }
            else if (day27.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day27.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day34.text = goal1
            }
        }
        else if (goal1 == "Saturday")
        {
            if(day7.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day7.text = goal1
            }
            else if (day14.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day14.text = goal1
            }
            else if (day21.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day21.text = goal1
            }
            else if (day28.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day28.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date02)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day35.text = goal1
            }
        }

        // date 3

        if (goal2 == "Sunday")
        {
            if(day1.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day1.text = goal1
            }
            else if (day8.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day8.text = goal1
            }
            else if (day15.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day15.text = goal1
            }
            else if (day22.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day22.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day29.text = goal1
            }
        }
        else if (goal2 == "Monday")
        {
            if(day2.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day2.text = goal1
            }
            else if (day9.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day9.text = goal1
            }
            else if (day16.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day16.text = goal1
            }
            else if (day23.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day23.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day30.text = goal1
            }
        }
        else if (goal2 == "Tuesday")
        {
            if(day3.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day3.text = goal1
            }
            else if (day10.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day10.text = goal1
            }
            else if (day17.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day17.text = goal1
            }
            else if (day24.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day24.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day31.text = goal1
            }
        }
        else if (goal2 == "Wednesday")
        {
            if(day4.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day4.text = goal1
            }
            else if (day11.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day11.text = goal1
            }
            else if (day18.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day18.text = goal1
            }
            else if (day25.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day25.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day32.text = goal1
            }
        }
        else if (goal2 == "Thursday")
        {
            if(day5.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day5.text = goal1
            }
            else if (day12.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day12.text = goal1
            }
            else if (day19.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day19.text = goal1
            }
            else if (day26.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day26.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day33.text = goal1
            }
        }
        else if (goal2 == "Friday")
        {
            if(day6.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day6.text = goal1
            }
            else if (day13.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day13.text = goal1
            }
            else if (day20.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day20.text = goal1
            }
            else if (day27.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day27.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day34.text = goal1
            }
        }
        else if (goal2 == "Saturday")
        {
            if(day7.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day7.text = goal1
            }
            else if (day14.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day14.text = goal1
            }
            else if (day21.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day21.text = goal1
            }
            else if (day28.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day28.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date03)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day35.text = goal1
            }
        }

        // date 4

        if (goal == "Sunday")
        {
            if(day1.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day1.text = goal1
            }
            else if (day8.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day8.text = goal1
            }
            else if (day15.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day15.text = goal1
            }
            else if (day22.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day22.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day29.text = goal1
            }
        }
        else if (goal == "Monday")
        {
            if(day2.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day2.text = goal1
            }
            else if (day9.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day9.text = goal1
            }
            else if (day16.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day16.text = goal1
            }
            else if (day23.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day23.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day30.text = goal1
            }
        }
        else if (goal == "Tuesday")
        {
            if(day3.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day3.text = goal1
            }
            else if (day10.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day10.text = goal1
            }
            else if (day17.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day17.text = goal1
            }
            else if (day24.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day24.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day31.text = goal1
            }
        }
        else if (goal == "Wednesday")
        {
            if(day4.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day4.text = goal1
            }
            else if (day11.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day11.text = goal1
            }
            else if (day18.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day18.text = goal1
            }
            else if (day25.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day25.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day32.text = goal1
            }
        }
        else if (goal == "Thursday")
        {
            if(day5.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day5.text = goal1
            }
            else if (day12.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day12.text = goal1
            }
            else if (day19.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day19.text = goal1
            }
            else if (day26.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day26.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day33.text = goal1
            }
        }
        else if (goal == "Friday")
        {
            if(day6.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day6.text = goal1
            }
            else if (day13.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day13.text = goal1
            }
            else if (day20.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day20.text = goal1
            }
            else if (day27.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day27.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day34.text = goal1
            }
        }
        else if (goal == "Saturday")
        {
            if(day7.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day7.text = goal1
            }
            else if (day14.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day14.text = goal1
            }
            else if (day21.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day21.text = goal1
            }
            else if (day28.text.equals(""))
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day28.text = goal1
            }
            else
            {
                val date1: Date? = inFormat1.parse(date01)
                val outFormat1 = SimpleDateFormat("dd")
                val goal1 = outFormat1.format(date1)
                day35.text = goal1
            }
        }






    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }
}