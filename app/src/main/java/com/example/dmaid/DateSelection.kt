package com.example.dmaid

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class DateSelection : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var firebaseauth: FirebaseAuth
    lateinit var dateEdt: EditText
    private lateinit var spinner: Spinner
    private lateinit var selected: String
    private lateinit var Dspinner: Spinner
    private lateinit var selecteddays: String
    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var text3: TextView
    private lateinit var text4: TextView
    private lateinit var confirmbtn: Button
    private lateinit var radiogroup: RadioGroup
    private lateinit var shift1: RadioButton
    private lateinit var shift2: RadioButton
    private lateinit var shift3: RadioButton
    var shift = ""
    var days0 = ""
    var days1 = ""
    var days2 = ""
    var days3 = ""
    var days4 = ""
    var days5 = ""

    var seldays = ""

    var a = 0


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


    private lateinit var checkMon: CheckBox
    private lateinit var checkTue: CheckBox
    private lateinit var checkWed: CheckBox
    private lateinit var checkThu: CheckBox
    private lateinit var checkFri: CheckBox
    private lateinit var checkSat: CheckBox

    private lateinit var backbtn: ImageView


    var count = 0

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

    var d1 = ""
    var d2 = ""
    var d3 = ""
    var d4 = ""
    var d5 = ""
    var d6 = ""
    var d7 = ""
    var d8 = ""
    var d9 = ""
    var d10 = ""
    var d11 = ""
    var d12 = ""
    var d13 = ""
    var d14 = ""
    var d15 = ""
    var d16 = ""
    var d17 = ""
    var d18 = ""
    var d19 = ""
    var d20 = ""
    var d21 = ""
    var d22 = ""
    var d23 = ""
    var d24 = ""
    var d25 = ""
    var d26 = ""
    var d27 = ""
    var d28 = ""
    var d29 = ""
    var d30 = ""

    private lateinit var firstname : String
    private lateinit var lastname : String
    private lateinit var fullname : String
    private lateinit var doorno : String

    private lateinit var stmaid :String
    private lateinit var stmaidid :String
    private lateinit var stmaid2 :String
    private lateinit var stmaidid2 :String


    var countdays = 0
    private lateinit var dayscount :String

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_selection)


        // initialising variables
        dateEdt = findViewById(R.id.editTextDate)
        spinner = findViewById(R.id.sizespinner)
        Dspinner = findViewById(R.id.dayspinner)
        text1 = findViewById(R.id.text1)
        confirmbtn = findViewById(R.id.confirmbtn)
        radiogroup = findViewById(R.id.radiog)

        database = FirebaseDatabase.getInstance()

        shift1 = findViewById(R.id.radio1)
        shift2 = findViewById(R.id.radio2)
        shift3 = findViewById(R.id.radio3)

        checkMon = findViewById(R.id.checkBox2)
        checkTue = findViewById(R.id.checkBox3)
        checkWed = findViewById(R.id.checkBox4)
        checkThu = findViewById(R.id.checkBox5)
        checkFri = findViewById(R.id.checkBox6)
        checkSat = findViewById(R.id.checkBox7)


        backbtn = findViewById(R.id.backbtn)
        backbtn.setOnClickListener {
            onBackPressed()
        }



        firebaseauth = FirebaseAuth.getInstance()







        // datepicker to select the starting date

        dateEdt.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)



                    val inFormat = SimpleDateFormat("dd-MM-yyyy")
                    val datest: Date? = inFormat.parse(dat)

                    val outFormat = SimpleDateFormat("EEEE")
                     goal = outFormat.format(datest)

                    Log.e(TAG,goal)

                    try {
                        val myDate = inFormat.parse(dat)
                        val c = Calendar.getInstance()
                        c.time = myDate
                        val newDate = c.time
                        Log.e(TAG, newDate.toString())
                        dateEdt.setText(inFormat.format(newDate))

                    } catch (e: ParseException) {
                        e.printStackTrace()
                        //handle exception
                    }


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
                    Log.e(TAG,date02)


                    val inFormat1 = SimpleDateFormat("dd-MM-yyyy")
                    val date1: Date? = inFormat1.parse(date02)
                    val outFormat1 = SimpleDateFormat("EEEE")
                    goal1 = outFormat1.format(date1)

                    Log.e(TAG,goal1)


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
                    Log.e(TAG,date03)

                    val inFormat2 = SimpleDateFormat("dd-MM-yyyy")
                    val date2: Date? = inFormat2.parse(date03)
                    val outFormat2 = SimpleDateFormat("EEEE")
                    goal2 = outFormat2.format(date2)

                    Log.e(TAG,goal2)


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
                    Log.e(TAG,date04)

                    val inFormat3 = SimpleDateFormat("dd-MM-yyyy")
                    val date3: Date? = inFormat3.parse(date04)
                    val outFormat3 = SimpleDateFormat("EEEE")
                    goal3 = outFormat3.format(date3)

                    Log.e(TAG,goal3)

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
                    Log.e(TAG,date05)

                    val inFormat4 = SimpleDateFormat("dd-MM-yyyy")
                    val date4: Date? = inFormat4.parse(date05)
                    val outFormat4 = SimpleDateFormat("EEEE")
                    goal4 = outFormat4.format(date4)

                    Log.e(TAG,goal4)

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
                    Log.e(TAG,date06)

                    val inFormat5 = SimpleDateFormat("dd-MM-yyyy")
                    val date5: Date? = inFormat5.parse(date06)
                    val outFormat5 = SimpleDateFormat("EEEE")
                    goal5 = outFormat5.format(date5)

                    Log.e(TAG,goal5)

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
                    Log.e(TAG,date07)

                    val inFormat6 = SimpleDateFormat("dd-MM-yyyy")
                    val date6: Date? = inFormat6.parse(date07)
                    val outFormat6 = SimpleDateFormat("EEEE")
                    goal6 = outFormat6.format(date6)

                    Log.e(TAG,goal6)

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
                    Log.e(TAG,date08)

                    val inFormat7 = SimpleDateFormat("dd-MM-yyyy")
                    val date7: Date? = inFormat7.parse(date08)
                    val outFormat7 = SimpleDateFormat("EEEE")
                    goal7 = outFormat7.format(date7)

                    Log.e(TAG,goal7)

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
                    Log.e(TAG,date09)

                    val inFormat8 = SimpleDateFormat("dd-MM-yyyy")
                    val date8: Date? = inFormat8.parse(date09)
                    val outFormat8 = SimpleDateFormat("EEEE")
                    goal8 = outFormat8.format(date8)

                    Log.e(TAG,goal8)

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
                    Log.e(TAG,date10)

                    val inFormat9 = SimpleDateFormat("dd-MM-yyyy")
                    val date9: Date? = inFormat9.parse(date10)
                    val outFormat9 = SimpleDateFormat("EEEE")
                    goal9 = outFormat9.format(date9)

                    Log.e(TAG,goal9)

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
                    Log.e(TAG,date11)

                    val inFormat10 = SimpleDateFormat("dd-MM-yyyy")
                    val date10: Date? = inFormat10.parse(date11)
                    val outFormat10 = SimpleDateFormat("EEEE")
                    goal10 = outFormat10.format(date10)

                    Log.e(TAG,goal10)

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
                    Log.e(TAG,date12)

                    val inFormat11 = SimpleDateFormat("dd-MM-yyyy")
                    val date11: Date? = inFormat11.parse(date12)
                    val outFormat11 = SimpleDateFormat("EEEE")
                    goal11 = outFormat11.format(date11)

                    Log.e(TAG,goal11)

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
                    Log.e(TAG,date13)

                    val inFormat12 = SimpleDateFormat("dd-MM-yyyy")
                    val date12: Date? = inFormat12.parse(date13)
                    val outFormat12 = SimpleDateFormat("EEEE")
                    goal12 = outFormat12.format(date12)

                    Log.e(TAG,goal12)

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
                    Log.e(TAG,date14)

                    val inFormat13 = SimpleDateFormat("dd-MM-yyyy")
                    val date13: Date? = inFormat13.parse(date14)
                    val outFormat13 = SimpleDateFormat("EEEE")
                    goal13 = outFormat13.format(date13)

                    Log.e(TAG,goal13)

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
                    Log.e(TAG,date15)

                    val inFormat14 = SimpleDateFormat("dd-MM-yyyy")
                    val date14: Date? = inFormat14.parse(date15)
                    val outFormat14 = SimpleDateFormat("EEEE")
                    goal14 = outFormat14.format(date14)

                    Log.e(TAG,goal14)

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
                    Log.e(TAG,date16)

                    val inFormat15 = SimpleDateFormat("dd-MM-yyyy")
                    val date15: Date? = inFormat15.parse(date16)
                    val outFormat15 = SimpleDateFormat("EEEE")
                    goal15 = outFormat15.format(date15)

                    Log.e(TAG,goal15)

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
                    Log.e(TAG,date17)

                    val inFormat16 = SimpleDateFormat("dd-MM-yyyy")
                    val date16: Date? = inFormat16.parse(date17)
                    val outFormat16 = SimpleDateFormat("EEEE")
                    goal16 = outFormat16.format(date16)

                    Log.e(TAG,goal16)

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
                    Log.e(TAG,date18)

                    val inFormat17 = SimpleDateFormat("dd-MM-yyyy")
                    val date17: Date? = inFormat17.parse(date18)
                    val outFormat17 = SimpleDateFormat("EEEE")
                    goal17 = outFormat17.format(date17)

                    Log.e(TAG,goal17)

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
                    Log.e(TAG,date19)

                    val inFormat18 = SimpleDateFormat("dd-MM-yyyy")
                    val date18: Date? = inFormat18.parse(date19)
                    val outFormat18 = SimpleDateFormat("EEEE")
                    goal18 = outFormat18.format(date18)

                    Log.e(TAG,goal18)

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
                    Log.e(TAG,date20)

                    val inFormat19 = SimpleDateFormat("dd-MM-yyyy")
                    val date19: Date? = inFormat19.parse(date20)
                    val outFormat19 = SimpleDateFormat("EEEE")
                    goal19 = outFormat19.format(date19)

                    Log.e(TAG,goal19)

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
                    Log.e(TAG,date21)

                    val inFormat20 = SimpleDateFormat("dd-MM-yyyy")
                    val date20: Date? = inFormat20.parse(date21)
                    val outFormat20 = SimpleDateFormat("EEEE")
                    goal20 = outFormat20.format(date20)

                    Log.e(TAG,goal20)

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
                    Log.e(TAG,date22)

                    val inFormat21 = SimpleDateFormat("dd-MM-yyyy")
                    val date21: Date? = inFormat21.parse(date22)
                    val outFormat21 = SimpleDateFormat("EEEE")
                    goal21 = outFormat21.format(date21)

                    Log.e(TAG,goal21)



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
                    Log.e(TAG,date23)

                    val inFormat22 = SimpleDateFormat("dd-MM-yyyy")
                    val date22: Date? = inFormat22.parse(date23)
                    val outFormat22 = SimpleDateFormat("EEEE")
                    goal22 = outFormat22.format(date22)

                    Log.e(TAG,goal22)

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
                    Log.e(TAG,date24)

                    val inFormat23 = SimpleDateFormat("dd-MM-yyyy")
                    val date23: Date? = inFormat23.parse(date24)
                    val outFormat23 = SimpleDateFormat("EEEE")
                    goal23 = outFormat23.format(date23)

                    Log.e(TAG,goal23)

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
                    Log.e(TAG,date25)

                    val inFormat24 = SimpleDateFormat("dd-MM-yyyy")
                    val date24: Date? = inFormat24.parse(date25)
                    val outFormat24 = SimpleDateFormat("EEEE")
                    goal24 = outFormat24.format(date24)

                    Log.e(TAG,goal24)

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
                    Log.e(TAG,date26)

                    val inFormat25 = SimpleDateFormat("dd-MM-yyyy")
                    val date25: Date? = inFormat25.parse(date26)
                    val outFormat25 = SimpleDateFormat("EEEE")
                    goal25 = outFormat25.format(date25)

                    Log.e(TAG,goal25)

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
                    Log.e(TAG,date27)

                    val inFormat26 = SimpleDateFormat("dd-MM-yyyy")
                    val date26: Date? = inFormat26.parse(date27)
                    val outFormat26 = SimpleDateFormat("EEEE")
                    goal26 = outFormat26.format(date26)

                    Log.e(TAG,goal26)

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
                    Log.e(TAG,date28)

                    val inFormat27 = SimpleDateFormat("dd-MM-yyyy")
                    val date27: Date? = inFormat27.parse(date28)
                    val outFormat27 = SimpleDateFormat("EEEE")
                    goal27 = outFormat27.format(date27)

                    Log.e(TAG,goal27)

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
                    Log.e(TAG,date29)

                    val inFormat28 = SimpleDateFormat("dd-MM-yyyy")
                    val date28: Date? = inFormat28.parse(date29)
                    val outFormat28 = SimpleDateFormat("EEEE")
                    goal28 = outFormat28.format(date28)

                    Log.e(TAG,goal28)

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
                    Log.e(TAG,date30)

                    val inFormat29 = SimpleDateFormat("dd-MM-yyyy")
                    val date29: Date? = inFormat29.parse(date30)
                    val outFormat29 = SimpleDateFormat("EEEE")
                    goal29 = outFormat29.format(date29)

                    Log.e(TAG,goal29)




                },
                year,
                month,
                day
            )


            c.add(Calendar.DATE, 1)
           datePickerDialog.datePicker.minDate = c.timeInMillis

            datePickerDialog.show()



        }


        // apartment size spinner

        val size = arrayOf("1BHK", "2BHK", "3BHK", "4BHK", "5BHK", "6BHK")
        val one = size[0]
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, size)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selected = size[p2].toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        Log.e(TAG,"arraylist  is $one")

        // convenient days spinner

        val cdays = arrayOf(
            "Daily",
            "Weekly Five Times (W5)",
            "Weekly Four Times (W4)",
            "Weekly Three Times (W3)",
            "Weekly Two Times (W2)",
            "Weekly One Time (W1)"
        )
        val arrayAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cdays)
        Dspinner.adapter = arrayAdapter2
        Dspinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selecteddays = cdays[p2].toString()
                if (selecteddays.equals("Daily")) {
                    text1.visibility = View.VISIBLE

                } else if (selecteddays.equals("Weekly Five Times (W5)")) {
                    text1.text = "Please Select Any Five Days"


                } else if (selecteddays.equals("Weekly Four Times (W4)")) {
                    text1.text = "Please Select Any Four Days"
                } else if (selecteddays.equals("Weekly Three Times (W3)")) {
                    text1.text = "Please Select Any Three Days"
                } else if (selecteddays.equals("Weekly Two Times (W2)")) {
                    text1.text = "Please Select Any Two Days"
                } else {
                    text1.text = "Please Select One Day"
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        radiogroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radio1) {
                shift = shift1.text.toString()
            } else if (checkedId == R.id.radio2) {
                shift = shift2.text.toString()
            } else {
                shift = shift3.text.toString()
            }
        }

        checkMon.setOnCheckedChangeListener { compoundButton, b ->

            if (checkMon.isChecked) {
                days0 = " Monday"
                count = count + 1
            } else {
                days0 = ""
                count = count - 1
            }
        }
        checkTue.setOnCheckedChangeListener { compoundButton, b ->
            if (checkTue.isChecked) {
                days1 = " Tuesday"
                count = count + 1
            } else {
                days1 = ""
                count = count - 1
            }
        }
        checkWed.setOnCheckedChangeListener { compoundButton, b ->
            if (checkWed.isChecked) {
                days2 = " Wednesday"
                count = count + 1
            } else {
                days2 = ""
                count = count - 1
            }
        }
        checkThu.setOnCheckedChangeListener { compoundButton, b ->
            if (checkThu.isChecked) {
                days3 = " Thursday"
                count = count + 1
            } else {
                days3 = ""
                count = count - 1
            }
        }
        checkFri.setOnCheckedChangeListener { compoundButton, b ->
            if (checkFri.isChecked) {
                days4 = " Friday"
                count = count + 1
            } else {
                days4 = ""
                count = count - 1
            }
        }
        checkSat.setOnCheckedChangeListener { compoundButton, b ->
            if (checkSat.isChecked) {
                days5 = " Saturday"
                count = count + 1
            } else {
                days5 = ""
                count = count - 1
            }
        }

        seldays = days0 + days1 + days2 + days3 + days4 + days5

        // find user name


        val bookingsRef = FirebaseDatabase.getInstance().getReference("users")
        val bookings1Ref = bookingsRef.child(firebaseauth.currentUser!!.uid)


        bookings1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                firstname = dataSnapshot.child("firstname").getValue(String::class.java).toString()
                lastname = dataSnapshot.child("lastname").getValue(String::class.java).toString()
                doorno = dataSnapshot.child("doorNo").getValue(String::class.java).toString()

                fullname = firstname + lastname
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })

        val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
        val bookings1Ref1 = bookingsRef1.child(firebaseauth.currentUser!!.uid)


        bookings1Ref1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })





        // saving data to the database
        confirmbtn.setOnClickListener {


            val startdate = dateEdt.text.toString()
            val apartmentsize = selected
            val freequency = selecteddays
            val days = days0 + days1 + days2 + days3 + days4 + days5
            val shift = shift.toString()
            val allocatedMaid = ""
            val allotedMaidId = ""
            val allocatedMaid1 = ""
            val allotedMaidId1 = ""
            val uid = firebaseauth.currentUser!!.uid



            if (days0 == " Monday")
            {
                if (goal == "Monday")
                {
                    val date001 = dateEdt.text.toString()
                    d1 = date001
                    countdays = countdays + 1
                    Log.e(TAG," date is $date001")
                }
                if (goal1 == "Monday")
                {
                    val date002 = date02
                    d1 = date002
                    countdays = countdays + 1
                    Log.e(TAG," date is $date002")
                }
                if (goal2 == "Monday")
                {
                    val date003 = date03
                    d1 = date003
                    countdays = countdays + 1
                    Log.e(TAG," date is $date003")
                }
                if (goal3 == "Monday")
                {
                    val date004 = date04
                    d1 = date004
                    countdays = countdays + 1
                    Log.e(TAG," date is $date004")
                }
                if (goal4 == "Monday")
                {
                    val date005 = date05
                    d1 = date005
                    countdays = countdays + 1
                    Log.e(TAG," date is $date005")
                }
                if (goal5 == "Monday")
                {
                    val date006 = date06
                    d1 = date006
                    countdays = countdays + 1
                    Log.e(TAG," date is $date006")
                }
                if (goal6 == "Monday")
                {
                    val date007 = date07
                    d1 = date007
                    countdays = countdays + 1
                    Log.e(TAG," date is $date007")
                }
                if (goal7 == "Monday")
                {
                    val date008 = date08
                    d2 = date008
                    countdays = countdays + 1
                    Log.e(TAG," date is $date008")
                }
                if (goal8 == "Monday")
                {
                    val date009 = date09
                    d2 = date009
                    countdays = countdays + 1
                    Log.e(TAG," date is $date009")
                }
                if (goal9 == "Monday")
                {
                    val date010 = date10
                    d2 = date010
                    countdays = countdays + 1
                    Log.e(TAG," date is $date010")
                }
                if (goal10 == "Monday")
                {
                    val date011 = date11
                    d2 = date011
                    countdays = countdays + 1
                    Log.e(TAG," date is $date011")
                }
                if (goal11 == "Monday")
                {
                    val date012 = date12
                    d2 = date012
                    countdays = countdays + 1
                    Log.e(TAG," date is $date012")
                }
                if (goal12 == "Monday")
                {
                    val date013 = date13
                    d2 = date013
                    countdays = countdays + 1
                    Log.e(TAG," date is $date013")
                }
                if (goal13 == "Monday")
                {
                    val date014 = date14
                    d2 = date014
                    countdays = countdays + 1
                    Log.e(TAG," date is $date014")
                }
                if (goal14 == "Monday")
                {
                    val date015 = date15
                    d3 = date015
                    countdays = countdays + 1
                    Log.e(TAG," date is $date015")
                }
                if (goal15 == "Monday")
                {
                    val date016 = date16
                    d3 = date016
                    countdays = countdays + 1
                    Log.e(TAG," date is $date016")
                }
                if (goal16 == "Monday")
                {
                    val date017 = date17
                    d3 = date017
                    countdays = countdays + 1
                    Log.e(TAG," date is $date017")
                }
                if (goal17 == "Monday")
                {
                    val date018 = date18
                    d3 = date018
                    countdays = countdays + 1
                    Log.e(TAG," date is $date018")
                }
                if (goal18 == "Monday")
                {
                    val date019 = date19
                    d3 = date019
                    countdays = countdays + 1
                    Log.e(TAG," date is $date019")
                }
                if (goal19 == "Monday")
                {
                    val date020 = date20
                    d3 = date020
                    countdays = countdays + 1
                    Log.e(TAG," date is $date020")
                }
                if (goal20 == "Monday")
                {
                    val date021 = date21
                    d3 = date021
                    countdays = countdays + 1
                    Log.e(TAG," date is $date021")
                }
                if (goal21 == "Monday")
                {
                    val date022 = date22
                    d4 = date022
                    countdays = countdays + 1
                    Log.e(TAG," date is $date022")
                }
                if (goal22 == "Monday")
                {
                    val date023 = date23
                    d4 = date023
                    countdays = countdays + 1
                    Log.e(TAG," date is $date023")
                }
                if (goal23 == "Monday")
                {
                    val date024 = date24
                    d4 = date024
                    countdays = countdays + 1
                    Log.e(TAG," date is $date024")
                }
                if (goal24 == "Monday")
                {
                    val date025 = date25
                    d4 = date025
                    countdays = countdays + 1
                    Log.e(TAG," date is $date025")
                }
                if (goal25 == "Monday")
                {
                    val date026 = date26
                    d4 = date026
                    countdays = countdays + 1
                    Log.e(TAG," date is $date026")
                }
                if (goal26 == "Monday")
                {
                    val date027 = date27
                    d4 = date027
                    countdays = countdays + 1
                    Log.e(TAG," date is $date027")
                }
                if (goal27 == "Monday")
                {
                    val date028 = date28
                    d4 = date028
                    countdays = countdays + 1
                    Log.e(TAG," date is $date028")
                }
                if (goal28 == "Monday")
                {
                    val date029 = date29
                    d5 = date029
                    countdays = countdays + 1
                    Log.e(TAG," date is $date029")
                }
                if (goal29 == "Monday")
                {
                    val date030 = date30
                    d5 = date030
                    countdays = countdays + 1
                    Log.e(TAG," date is $date030")
                }
            }

            // tuesday

            if (days1 == " Tuesday")
            {
                if (goal == "Tuesday")
                {
                    val date001 = dateEdt.text.toString()
                    d6 = date001
                    countdays = countdays + 1
                    Log.e(TAG," date is $date001")
                }
                if (goal1 == "Tuesday")
                {
                    val date002 = date02
                    d6 = date002
                    countdays = countdays + 1
                    Log.e(TAG," date is $date002")
                }
                if (goal2 == "Tuesday")
                {
                    val date003 = date03
                    d6 = date003
                    countdays = countdays + 1
                    Log.e(TAG," date is $date003")
                }
                if (goal3 == "Tuesday")
                {
                    val date004 = date04
                    d6 = date004
                    countdays = countdays + 1
                    Log.e(TAG," date is $date004")
                }
                if (goal4 == "Tuesday")
                {
                    val date005 = date05
                    d6 = date005
                    countdays = countdays + 1
                    Log.e(TAG," date is $date005")
                }
                if (goal5 == "Tuesday")
                {
                    val date006 = date06
                    d6 = date006
                    countdays = countdays + 1
                    Log.e(TAG," date is $date006")
                }
                if (goal6 == "Tuesday")
                {
                    val date007 = date07
                    d6 = date007
                    countdays = countdays + 1
                    Log.e(TAG," date is $date007")
                }
                if (goal7 == "Tuesday")
                {
                    val date008 = date08
                    d7 = date008
                    countdays = countdays + 1
                    Log.e(TAG," date is $date008")
                }
                if (goal8 == "Tuesday")
                {
                    val date009 = date09
                    d7 = date009
                    countdays = countdays + 1
                    Log.e(TAG," date is $date009")
                }
                if (goal9 == "Tuesday")
                {
                    val date010 = date10
                    d7 = date010
                    countdays = countdays + 1
                    Log.e(TAG," date is $date010")
                }
                if (goal10 == "Tuesday")
                {
                    val date011 = date11
                    d7 = date011
                    countdays = countdays + 1
                    Log.e(TAG," date is $date011")
                }
                if (goal11 == "Tuesday")
                {
                    val date012 = date12
                    d7 = date012
                    countdays = countdays + 1
                    Log.e(TAG," date is $date012")
                }
                if (goal12 == "Tuesday")
                {
                    val date013 = date13
                    d7 = date013
                    countdays = countdays + 1
                    Log.e(TAG," date is $date013")
                }
                if (goal13 == "Tuesday")
                {
                    val date014 = date14
                    d7 = date014
                    countdays = countdays + 1
                    Log.e(TAG," date is $date014")
                }
                if (goal14 == "Tuesday")
                {
                    val date015 = date15
                    d8 = date015
                    countdays = countdays + 1
                    Log.e(TAG," date is $date015")
                }
                if (goal15 == "Tuesday")
                {
                    val date016 = date16
                    d8 = date016
                    countdays = countdays + 1
                    Log.e(TAG," date is $date016")
                }
                if (goal16 == "Tuesday")
                {
                    val date017 = date17
                    d8 = date017
                    countdays = countdays + 1
                    Log.e(TAG," date is $date017")
                }
                if (goal17 == "Tuesday")
                {
                    val date018 = date18
                    d8 = date018
                    countdays = countdays + 1
                    Log.e(TAG," date is $date018")
                }
                if (goal18 == "Tuesday")
                {
                    val date019 = date19
                    d8 = date019
                    countdays = countdays + 1
                    Log.e(TAG," date is $date019")
                }
                if (goal19 == "Tuesday")
                {
                    val date020 = date20
                    d8 = date020
                    countdays = countdays + 1
                    Log.e(TAG," date is $date020")
                }
                if (goal20 == "Tuesday")
                {
                    val date021 = date21
                    d8 = date021
                    countdays = countdays + 1
                    Log.e(TAG," date is $date021")
                }
                if (goal21 == "Tuesday")
                {
                    val date022 = date22
                    d9 = date022
                    countdays = countdays + 1
                    Log.e(TAG," date is $date022")
                }
                if (goal22 == "Tuesday")
                {
                    val date023 = date23
                    d9 = date023
                    countdays = countdays + 1
                    Log.e(TAG," date is $date023")
                }
                if (goal23 == "Tuesday")
                {
                    val date024 = date24
                    d9 = date024
                    countdays = countdays + 1
                    Log.e(TAG," date is $date024")
                }
                if (goal24 == "Tuesday")
                {
                    val date025 = date25
                    d9 = date025
                    countdays = countdays + 1
                    Log.e(TAG," date is $date025")
                }
                if (goal25 == "Tuesday")
                {
                    val date026 = date26
                    d9 = date026
                    countdays = countdays + 1
                    Log.e(TAG," date is $date026")
                }
                if (goal26 == "Tuesday")
                {
                    val date027 = date27
                    d9 = date027
                    countdays = countdays + 1
                    Log.e(TAG," date is $date027")
                }
                if (goal27 == "Tuesday")
                {
                    val date028 = date28
                    d9 = date028
                    countdays = countdays + 1
                    Log.e(TAG," date is $date028")
                }
                if (goal28 == "Tuesday")
                {
                    val date029 = date29
                    d10 = date029
                    countdays = countdays + 1
                    Log.e(TAG," date is $date029")
                }
                if (goal29 == "Tuesday")
                {
                    val date030 = date30
                    d10 = date030
                    countdays = countdays + 1
                    Log.e(TAG," date is $date030")
                }
            }

            // wednesday

            if (days2 == " Wednesday")
            {
                if (goal == "Wednesday")
                {
                    val date001 = dateEdt.text.toString()
                    d11 = date001
                    countdays = countdays + 1
                    Log.e(TAG," date is $date001")
                }
                if (goal1 == "Wednesday")
                {
                    val date002 = date02
                    d11 = date002
                    countdays = countdays + 1
                    Log.e(TAG," date is $date002")
                }
                if (goal2 == "Wednesday")
                {
                    val date003 = date03
                    d11 = date003
                    countdays = countdays + 1
                    Log.e(TAG," date is $date003")
                }
                if (goal3 == "Wednesday")
                {
                    val date004 = date04
                    d11 = date004
                    countdays = countdays + 1
                    Log.e(TAG," date is $date004")
                }
                if (goal4 == "Wednesday")
                {
                    val date005 = date05
                    d11 = date005
                    countdays = countdays + 1
                    Log.e(TAG," date is $date005")
                }
                if (goal5 == "Wednesday")
                {
                    val date006 = date06
                    d11 = date006
                    countdays = countdays + 1
                    Log.e(TAG," date is $date006")
                }
                if (goal6 == "Wednesday")
                {
                    val date007 = date07
                    d11 = date007
                    countdays = countdays + 1
                    Log.e(TAG," date is $date007")
                }
                if (goal7 == "Wednesday")
                {
                    val date008 = date08
                    d12 = date008
                    countdays = countdays + 1
                    Log.e(TAG," date is $date008")
                }
                if (goal8 == "Wednesday")
                {
                    val date009 = date09
                    d12 = date009
                    countdays = countdays + 1
                    Log.e(TAG," date is $date009")
                }
                if (goal9 == "Wednesday")
                {
                    val date010 = date10
                    d12 = date010
                    countdays = countdays + 1
                    Log.e(TAG," date is $date010")
                }
                if (goal10 == "Wednesday")
                {
                    val date011 = date11
                    d12 = date011
                    countdays = countdays + 1
                    Log.e(TAG," date is $date011")
                }
                if (goal11 == "Wednesday")
                {
                    val date012 = date12
                    d12 = date012
                    countdays = countdays + 1
                    Log.e(TAG," date is $date012")
                }
                if (goal12 == "Wednesday")
                {
                    val date013 = date13
                    d12 = date013
                    countdays = countdays + 1
                    Log.e(TAG," date is $date013")
                }
                if (goal13 == "Wednesday")
                {
                    val date014 = date14
                    d12 = date014
                    countdays = countdays + 1
                    Log.e(TAG," date is $date014")
                }
                if (goal14 == "Wednesday")
                {
                    val date015 = date15
                    d13 = date015
                    countdays = countdays + 1
                    Log.e(TAG," date is $date015")
                }
                if (goal15 == "Wednesday")
                {
                    val date016 = date16
                    d13 = date016
                    countdays = countdays + 1
                    Log.e(TAG," date is $date016")
                }
                if (goal16 == "Wednesday")
                {
                    val date017 = date17
                    d13 = date017
                    countdays = countdays + 1
                    Log.e(TAG," date is $date017")
                }
                if (goal17 == "Wednesday")
                {
                    val date018 = date18
                    d13 = date018
                    countdays = countdays + 1
                    Log.e(TAG," date is $date018")
                }
                if (goal18 == "Wednesday")
                {
                    val date019 = date19
                    d13 = date019
                    countdays = countdays + 1
                    Log.e(TAG," date is $date019")
                }
                if (goal19 == "Wednesday")
                {
                    val date020 = date20
                    d13 = date020
                    countdays = countdays + 1
                    Log.e(TAG," date is $date020")
                }
                if (goal20 == "Wednesday")
                {
                    val date021 = date21
                    d13 = date021
                    countdays = countdays + 1
                    Log.e(TAG," date is $date021")
                }
                if (goal21 == "Wednesday")
                {
                    val date022 = date22
                    d14 = date022
                    countdays = countdays + 1
                    Log.e(TAG," date is $date022")
                }
                if (goal22 == "Wednesday")
                {
                    val date023 = date23
                    d14 = date023
                    countdays = countdays + 1
                    Log.e(TAG," date is $date023")
                }
                if (goal23 == "Wednesday")
                {
                    val date024 = date24
                    d14 = date024
                    countdays = countdays + 1
                    Log.e(TAG," date is $date024")
                }
                if (goal24 == "Wednesday")
                {
                    val date025 = date25
                    d14 = date025
                    countdays = countdays + 1
                    Log.e(TAG," date is $date025")
                }
                if (goal25 == "Wednesday")
                {
                    val date026 = date26
                    d14 = date026
                    countdays = countdays + 1
                    Log.e(TAG," date is $date026")
                }
                if (goal26 == "Wednesday")
                {
                    val date027 = date27
                    d14 = date027
                    countdays = countdays + 1
                    Log.e(TAG," date is $date027")
                }
                if (goal27 == "Wednesday")
                {
                    val date028 = date28
                    d14 = date028
                    countdays = countdays + 1
                    Log.e(TAG," date is $date028")
                }
                if (goal28 == "Wednesday")
                {
                    val date029 = date29
                    d15 = date029
                    countdays = countdays + 1
                    Log.e(TAG," date is $date029")
                }
                if (goal29 == "Wednesday")
                {
                    val date030 = date30
                    d15 = date030
                    countdays = countdays + 1
                    Log.e(TAG," date is $date030")
                }
            }


            // thursday

            if (days3 == " Thursday")
            {
                if (goal == "Thursday")
                {
                    val date001 = dateEdt.text.toString()
                    d16 = date001
                    countdays = countdays + 1
                    Log.e(TAG," date is $date001")
                }
                if (goal1 == "Thursday")
                {
                    val date002 = date02
                    d16 = date002
                    countdays = countdays + 1
                    Log.e(TAG," date is $date002")
                }
                if (goal2 == "Thursday")
                {
                    val date003 = date03
                    d16 = date003
                    countdays = countdays + 1
                    Log.e(TAG," date is $date003")
                }
                if (goal3 == "Thursday")
                {
                    val date004 = date04
                    d16 = date004
                    countdays = countdays + 1
                    Log.e(TAG," date is $date004")
                }
                if (goal4 == "Thursday")
                {
                    val date005 = date05
                    d16 = date005
                    countdays = countdays + 1
                    Log.e(TAG," date is $date005")
                }
                if (goal5 == "Thursday")
                {
                    val date006 = date06
                    d16 = date006
                    countdays = countdays + 1
                    Log.e(TAG," date is $date006")
                }
                if (goal6 == "Thursday")
                {
                    val date007 = date07
                    d16 = date007
                    countdays = countdays + 1
                    Log.e(TAG," date is $date007")
                }
                if (goal7 == "Thursday")
                {
                    val date008 = date08
                    d17 = date008
                    countdays = countdays + 1
                    Log.e(TAG," date is $date008")
                }
                if (goal8 == "Thursday")
                {
                    val date009 = date09
                    d17 = date009
                    countdays = countdays + 1
                    Log.e(TAG," date is $date009")
                }
                if (goal9 == "Thursday")
                {
                    val date010 = date10
                    d17 = date010
                    countdays = countdays + 1
                    Log.e(TAG," date is $date010")
                }
                if (goal10 == "Thursday")
                {
                    val date011 = date11
                    d17 = date011
                    countdays = countdays + 1
                    Log.e(TAG," date is $date011")
                }
                if (goal11 == "Thursday")
                {
                    val date012 = date12
                    d17 = date012
                    countdays = countdays + 1
                    Log.e(TAG," date is $date012")
                }
                if (goal12 == "Thursday")
                {
                    val date013 = date13
                    d17 = date013
                    countdays = countdays + 1
                    Log.e(TAG," date is $date013")
                }
                if (goal13 == "Thursday")
                {
                    val date014 = date14
                    d17 = date014
                    countdays = countdays + 1
                    Log.e(TAG," date is $date014")
                }
                if (goal14 == "Thursday")
                {
                    val date015 = date15
                    d18 = date015
                    countdays = countdays + 1
                    Log.e(TAG," date is $date015")
                }
                if (goal15 == "Thursday")
                {
                    val date016 = date16
                    d18 = date016
                    countdays = countdays + 1
                    Log.e(TAG," date is $date016")
                }
                if (goal16 == "Thursday")
                {
                    val date017 = date17
                    d18 = date017
                    countdays = countdays + 1
                    Log.e(TAG," date is $date017")
                }
                if (goal17 == "Thursday")
                {
                    val date018 = date18
                    d18 = date018
                    countdays = countdays + 1
                    Log.e(TAG," date is $date018")
                }
                if (goal18 == "Thursday")
                {
                    val date019 = date19
                    d18 = date019
                    countdays = countdays + 1
                    Log.e(TAG," date is $date019")
                }
                if (goal19 == "Thursday")
                {
                    val date020 = date20
                    d18 = date020
                    countdays = countdays + 1
                    Log.e(TAG," date is $date020")
                }
                if (goal20 == "Thursday")
                {
                    val date021 = date21
                    d18 = date021
                    countdays = countdays + 1
                    Log.e(TAG," date is $date021")
                }
                if (goal21 == "Thursday")
                {
                    val date022 = date22
                    d19 = date022
                    countdays = countdays + 1
                    Log.e(TAG," date is $date022")
                }
                if (goal22 == "Thursday")
                {
                    val date023 = date23
                    d19 = date023
                    countdays = countdays + 1
                    Log.e(TAG," date is $date023")
                }
                if (goal23 == "Thursday")
                {
                    val date024 = date24
                    d19 = date024
                    countdays = countdays + 1
                    Log.e(TAG," date is $date024")
                }
                if (goal24 == "Thursday")
                {
                    val date025 = date25
                    d19 = date025
                    countdays = countdays + 1
                    Log.e(TAG," date is $date025")
                }
                if (goal25 == "Thursday")
                {
                    val date026 = date26
                    d19 = date026
                    countdays = countdays + 1
                    Log.e(TAG," date is $date026")
                }
                if (goal26 == "Thursday")
                {
                    val date027 = date27
                    d19 = date027
                    countdays = countdays + 1
                    Log.e(TAG," date is $date027")
                }
                if (goal27 == "Thursday")
                {
                    val date028 = date28
                    d19 = date028
                    countdays = countdays + 1
                    Log.e(TAG," date is $date028")
                }
                if (goal28 == "Thursday")
                {
                    val date029 = date29
                    d20 = date029
                    countdays = countdays + 1
                    Log.e(TAG," date is $date029")
                }
                if (goal29 == "Thursday")
                {
                    val date030 = date30
                    d20 = date030
                    countdays = countdays + 1
                    Log.e(TAG," date is $date030")
                }
            }

            // friday

            if (days4 == " Friday")
            {
                if (goal == "Friday")
                {
                    val date001 = dateEdt.text.toString()
                    d21 = date001
                    countdays = countdays + 1
                    Log.e(TAG," date is $date001")
                }
                if (goal1 == "Friday")
                {
                    val date002 = date02
                    d21 = date002
                    countdays = countdays + 1
                    Log.e(TAG," date is $date002")
                }
                if (goal2 == "Friday")
                {
                    val date003 = date03
                    d21 = date003
                    countdays = countdays + 1
                    Log.e(TAG," date is $date003")
                }
                if (goal3 == "Friday")
                {
                    val date004 = date04
                    d21 = date004
                    countdays = countdays + 1
                    Log.e(TAG," date is $date004")
                }
                if (goal4 == "Friday")
                {
                    val date005 = date05
                    d21 = date005
                    countdays = countdays + 1
                    Log.e(TAG," date is $date005")
                }
                if (goal5 == "Friday")
                {
                    val date006 = date06
                    d21 = date006
                    countdays = countdays + 1
                    Log.e(TAG," date is $date006")
                }
                if (goal6 == "Friday")
                {
                    val date007 = date07
                    d21 = date007
                    countdays = countdays + 1
                    Log.e(TAG," date is $date007")
                }
                if (goal7 == "Friday")
                {
                    val date008 = date08
                    d22 = date008
                    countdays = countdays + 1
                    Log.e(TAG," date is $date008")
                }
                if (goal8 == "Friday")
                {
                    val date009 = date09
                    d22 = date009
                    countdays = countdays + 1
                    Log.e(TAG," date is $date009")
                }
                if (goal9 == "Friday")
                {
                    val date010 = date10
                    d22 = date010
                    countdays = countdays + 1
                    Log.e(TAG," date is $date010")
                }
                if (goal10 == "Friday")
                {
                    val date011 = date11
                    d22 = date011
                    countdays = countdays + 1
                    Log.e(TAG," date is $date011")
                }
                if (goal11 == "Friday")
                {
                    val date012 = date12
                    d22 = date012
                    countdays = countdays + 1
                    Log.e(TAG," date is $date012")
                }
                if (goal12 == "Friday")
                {
                    val date013 = date13
                    d22 = date013
                    countdays = countdays + 1
                    Log.e(TAG," date is $date013")
                }
                if (goal13 == "Friday")
                {
                    val date014 = date14
                    d22 = date014
                    countdays = countdays + 1
                    Log.e(TAG," date is $date014")
                }
                if (goal14 == "Friday")
                {
                    val date015 = date15
                    d23 = date015
                    countdays = countdays + 1
                    Log.e(TAG," date is $date015")
                }
                if (goal15 == "Friday")
                {
                    val date016 = date16
                    d23 = date016
                    countdays = countdays + 1
                    Log.e(TAG," date is $date016")
                }
                if (goal16 == "Friday")
                {
                    val date017 = date17
                    d23 = date017
                    countdays = countdays + 1
                    Log.e(TAG," date is $date017")
                }
                if (goal17 == "Friday")
                {
                    val date018 = date18
                    d23 = date018
                    countdays = countdays + 1
                    Log.e(TAG," date is $date018")
                }
                if (goal18 == "Friday")
                {
                    val date019 = date19
                    d23 = date019
                    countdays = countdays + 1
                    Log.e(TAG," date is $date019")
                }
                if (goal19 == "Friday")
                {
                    val date020 = date20
                    d23 = date020
                    countdays = countdays + 1
                    Log.e(TAG," date is $date020")
                }
                if (goal20 == "Friday")
                {
                    val date021 = date21
                    d23 = date021
                    countdays = countdays + 1
                    Log.e(TAG," date is $date021")
                }
                if (goal21 == "Friday")
                {
                    val date022 = date22
                    d24 = date022
                    countdays = countdays + 1
                    Log.e(TAG," date is $date022")
                }
                if (goal22 == "Friday")
                {
                    val date023 = date23
                    d24 = date023
                    countdays = countdays + 1
                    Log.e(TAG," date is $date023")
                }
                if (goal23 == "Friday")
                {
                    val date024 = date24
                    d24 = date024
                    countdays = countdays + 1
                    Log.e(TAG," date is $date024")
                }
                if (goal24 == "Friday")
                {
                    val date025 = date25
                    d24 = date025
                    countdays = countdays + 1
                    Log.e(TAG," date is $date025")
                }
                if (goal25 == "Friday")
                {
                    val date026 = date26
                    d24 = date026
                    countdays = countdays + 1
                    Log.e(TAG," date is $date026")
                }
                if (goal26 == "Friday")
                {
                    val date027 = date27
                    d24 = date027
                    countdays = countdays + 1
                    Log.e(TAG," date is $date027")
                }
                if (goal27 == "Friday")
                {
                    val date028 = date28
                    d24 = date028
                    countdays = countdays + 1
                    Log.e(TAG," date is $date028")
                }
                if (goal28 == "Friday")
                {
                    val date029 = date29
                    d25 = date029
                    countdays = countdays + 1
                    Log.e(TAG," date is $date029")
                }
                if (goal29 == "Friday")
                {
                    val date030 = date30
                    d25 = date030
                    countdays = countdays + 1
                    Log.e(TAG," date is $date030")
                }
            }


            // Saturday

            if (days5 == " Saturday")
            {
                if (goal == "Saturday")
                {
                    val date001 = dateEdt.text.toString()
                    d26 = date001
                    countdays = countdays + 1
                    Log.e(TAG," date is $date001")
                }
                if (goal1 == "Saturday")
                {
                    val date002 = date02
                    d26 = date002
                    countdays = countdays + 1
                    Log.e(TAG," date is $date002")
                }
                if (goal2 == "Saturday")
                {
                    val date003 = date03
                    d26 = date003
                    countdays = countdays + 1
                    Log.e(TAG," date is $date003")
                }
                if (goal3 == "Saturday")
                {
                    val date004 = date04
                    d26 = date004
                    countdays = countdays + 1
                    Log.e(TAG," date is $date004")
                }
                if (goal4 == "Saturday")
                {
                    val date005 = date05
                    d26 = date005
                    countdays = countdays + 1
                    Log.e(TAG," date is $date005")
                }
                if (goal5 == "Saturday")
                {
                    val date006 = date06
                    d26 = date006
                    countdays = countdays + 1
                    Log.e(TAG," date is $date006")
                }
                if (goal6 == "Saturday")
                {
                    val date007 = date07
                    d26 = date007
                    countdays = countdays + 1
                    Log.e(TAG," date is $date007")
                }
                if (goal7 == "Saturday")
                {
                    val date008 = date08
                    d27 = date008
                    countdays = countdays + 1
                    Log.e(TAG," date is $date008")
                }
                if (goal8 == "Saturday")
                {
                    val date009 = date09
                    d27 = date009
                    countdays = countdays + 1
                    Log.e(TAG," date is $date009")
                }
                if (goal9 == "Saturday")
                {
                    val date010 = date10
                    d27 = date010
                    countdays = countdays + 1
                    Log.e(TAG," date is $date010")
                }
                if (goal10 == "Saturday")
                {
                    val date011 = date11
                    d27 = date011
                    countdays = countdays + 1
                    Log.e(TAG," date is $date011")
                }
                if (goal11 == "Saturday")
                {
                    val date012 = date12
                    d27 = date012
                    countdays = countdays + 1
                    Log.e(TAG," date is $date012")
                }
                if (goal12 == "Saturday")
                {
                    val date013 = date13
                    d27 = date013
                    countdays = countdays + 1
                    Log.e(TAG," date is $date013")
                }
                if (goal13 == "Saturday")
                {
                    val date014 = date14
                    d27 = date014
                    countdays = countdays + 1
                    Log.e(TAG," date is $date014")
                }
                if (goal14 == "Saturday")
                {
                    val date015 = date15
                    d28 = date015
                    countdays = countdays + 1
                    Log.e(TAG," date is $date015")
                }
                if (goal15 == "Saturday")
                {
                    val date016 = date16
                    d28 = date016
                    countdays = countdays + 1
                    Log.e(TAG," date is $date016")
                }
                if (goal16 == "Saturday")
                {
                    val date017 = date17
                    d28 = date017
                    countdays = countdays + 1
                    Log.e(TAG," date is $date017")
                }
                if (goal17 == "Saturday")
                {
                    val date018 = date18
                    d28 = date018
                    countdays = countdays + 1
                    Log.e(TAG," date is $date018")
                }
                if (goal18 == "Saturday")
                {
                    val date019 = date19
                    d28 = date019
                    countdays = countdays + 1
                    Log.e(TAG," date is $date019")
                }
                if (goal19 == "Saturday")
                {
                    val date020 = date20
                    d28 = date020
                    countdays = countdays + 1
                    Log.e(TAG," date is $date020")
                }
                if (goal20 == "Saturday")
                {
                    val date021 = date21
                    d28 = date021
                    countdays = countdays + 1
                    Log.e(TAG," date is $date021")
                }
                if (goal21 == "Saturday")
                {
                    val date022 = date22
                    d29 = date022
                    countdays = countdays + 1
                    Log.e(TAG," date is $date022")
                }
                if (goal22 == "Saturday")
                {
                    val date023 = date23
                    d29 = date023
                    countdays = countdays + 1
                    Log.e(TAG," date is $date023")
                }
                if (goal23 == "Saturday")
                {
                    val date024 = date24
                    d29 = date024
                    countdays = countdays + 1
                    Log.e(TAG," date is $date024")
                }
                if (goal24 == "Saturday")
                {
                    val date025 = date25
                    d29 = date025
                    countdays = countdays + 1
                    Log.e(TAG," date is $date025")
                }
                if (goal25 == "Saturday")
                {
                    val date026 = date26
                    d29 = date026
                    countdays = countdays + 1
                    Log.e(TAG," date is $date026")
                }
                if (goal26 == "Saturday")
                {
                    val date027 = date27
                    d29 = date027
                    countdays = countdays + 1
                    Log.e(TAG," date is $date027")
                }
                if (goal27 == "Saturday")
                {
                    val date028 = date28
                    d29 = date028
                    countdays = countdays + 1
                    Log.e(TAG," date is $date028")
                }
                if (goal28 == "Saturday")
                {
                    val date029 = date29
                    d30 = date029
                    countdays = countdays + 1
                    Log.e(TAG," date is $date029")
                }
                if (goal29 == "Saturday")
                {
                    val date030 = date30
                    d30 = date030
                    countdays = countdays + 1
                    Log.e(TAG," date is $date030")
                }
            }


Log.e(TAG, countdays.toString())


            val key1 = d1 + fullname
            if (d1.isNotEmpty())
            {
                val dbid = key1
                val ddate = d1
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key1)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                   dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key2 = d2 + fullname
            if (d2.isNotEmpty())
            {
                val dbid = key2
                val ddate = d2
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key2)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key3 = d3 + fullname
            if (d3.isNotEmpty())
            {
                val dbid = key3
                val ddate = d3
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key3)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key4 = d4 + fullname
            if (d4.isNotEmpty())
            {
                val dbid = key4
                val ddate = d4
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key4)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key5 = d5 + fullname
            if (d5.isNotEmpty())
            {
                val dbid = key5
                val ddate = d5
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key5)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key6 = d6 + fullname
            if (d6.isNotEmpty())
            {
                val dbid = key6
                val ddate = d6
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key6)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key7 = d7 + fullname
            if (d7.isNotEmpty())
            {
                val dbid = key7
                val ddate = d7
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key7)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key8 = d8 + fullname
            if (d8.isNotEmpty())
            {
                val dbid = key8
                val ddate = d8
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key8)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key9 = d9 + fullname
            if (d9.isNotEmpty())
            {
                val dbid = key9
                val ddate = d9
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key9)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

                val key10 = d10 + fullname
            if (d10.isNotEmpty())
            {
                val dbid = key10
                val ddate = d10
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key10)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

                val key11 = d11 + fullname
            if (d11.isNotEmpty())
            {
                val dbid = key11
                val ddate = d11
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key11)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

                val key12 = d12 + fullname
            if (d12.isNotEmpty())
            {
                val dbid = key12
                val ddate = d12
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key12)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

                val key13 = d13 + fullname
            if (d13.isNotEmpty())
            {
                val dbid = key13
                val ddate = d13
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key13)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key14 = d14 + fullname
            if (d14.isNotEmpty())
            {
                val dbid = key14
                val ddate = d14
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key14)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key15 = d15 + fullname
            if (d15.isNotEmpty())
            {
                val dbid = key15
                val ddate = d15
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key15)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key16 = d16 + fullname
            if (d16.isNotEmpty())
            {
                val dbid = key16
                val ddate = d16
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key16)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key17 = d17 + fullname
            if (d17.isNotEmpty())
            {
                val dbid = key17
                val ddate = d17
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key17)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key18 = d18 + fullname
            if (d18.isNotEmpty())
            {
                val dbid = key18
                val ddate = d18
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key18)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key19 = d19 + fullname
            if (d19.isNotEmpty())
            {
                val dbid = key19
                val ddate = d19
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key19)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key20 = d20 + fullname
            if (d20.isNotEmpty())
            {
                val dbid = key20
                val ddate = d20
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key20)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key21 = d21 + fullname
            if (d21.isNotEmpty())
            {
                val dbid = key21
                val ddate = d21
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key21)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key22 = d22 + fullname
            if (d22.isNotEmpty())
            {
                val dbid = key22
                val ddate = d22
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key22)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key23 = d23 + fullname
            if (d23.isNotEmpty())
            {
                val dbid = key23
                val ddate = d23
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key23)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key24 = d24 + fullname
            if (d24.isNotEmpty())
            {
                val dbid = key24
                val ddate = d24
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key24)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key25 = d25 + fullname
            if (d25.isNotEmpty())
            {
                val dbid = key25
                val ddate = d25
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key25)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key26 = d26 + fullname
            if (d26.isNotEmpty())
            {
                val dbid = key26
                val ddate = d26
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key26)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key27 = d27 + fullname
            if (d27.isNotEmpty())
            {
                val dbid = key27
                val ddate = d27
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key27)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key28 = d28 + fullname
            if (d28.isNotEmpty())
            {
                val dbid = key28
                val ddate = d28
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key28)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key29 = d29 + fullname
            if (d29.isNotEmpty())
            {
                val dbid = key29
                val ddate = d29
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key29)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }

            val key30 = d30 + fullname
            if (d30.isNotEmpty())
            {
                val dbid = key30
                val ddate = d30
                val dshift = shift.toString()
                val dcustomername = firstname + " " + lastname
                val dcustomerid = uid
                val ddoorNo = doorno
                val dmaid = stmaid
                val dmaidid = stmaidid
                val dmaid2 = stmaid2
                val dmaidid2 = stmaidid2
                val status = "Pending"

                val databaseRef = database.reference.child("datewisebookings")
                    .child(key30)
                val datewisebookings: DateWiseBookings = DateWiseBookings(
                    dbid, ddate, dshift, dcustomername, dcustomerid,ddoorNo, dmaid, dmaidid, dmaid2, dmaidid2, status
                )
                databaseRef.setValue(datewisebookings).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.w(TAG,dbid)
                    } else {
                        Log.e(TAG,dbid)
                    }
                }
            }




            val noofdays = countdays.toString()


            if (startdate.isNotEmpty()) {
                    if (apartmentsize.isNotEmpty()) {
                        if (freequency.isNotEmpty()) {
                            if (shift.isNotEmpty()) {
                                if (freequency.equals("Daily")) {
                                    if (count != 6) {
                                        Toast.makeText(
                                            this,
                                            "Please Select All Days",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        val databaseRef = database.reference.child("bookings")
                                            .child(firebaseauth.currentUser!!.uid)
                                        val bookings: Bookings = Bookings(
                                            startdate,
                                            apartmentsize,
                                            freequency,
                                            days,
                                            shift,
                                            allocatedMaid,
                                            allotedMaidId,
                                            allocatedMaid1,
                                            allotedMaidId1,
                                            noofdays,
                                            uid
                                        )
                                        databaseRef.setValue(bookings).addOnCompleteListener {
                                            if (it.isSuccessful) {
                                                Toast.makeText(
                                                    this,
                                                    "Service Scheduled Successfully",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                val intent = Intent(this, Cart::class.java)
                                                startActivity(intent)
                                                Log.e(TAG, count.toString())
                                            } else {
                                                Toast.makeText(
                                                    this,
                                                    it.exception.toString(),
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                }
                                if (freequency.equals("Weekly Five Times (W5)")) {
                                    if (count != 5) {
                                        Toast.makeText(
                                            this,
                                            "Please Select Five Days",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        val databaseRef = database.reference.child("bookings")
                                            .child(firebaseauth.currentUser!!.uid)
                                        val bookings: Bookings = Bookings(
                                            startdate,
                                            apartmentsize,
                                            freequency,
                                            days,
                                            shift,
                                            allocatedMaid,
                                            allotedMaidId,
                                            allocatedMaid1,
                                            allotedMaidId1,
                                            noofdays,
                                            uid
                                        )
                                        databaseRef.setValue(bookings).addOnCompleteListener {
                                            if (it.isSuccessful) {
                                                Toast.makeText(
                                                    this,
                                                    "Service Scheduled Successfully",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                val intent = Intent(this, Cart::class.java)
                                                startActivity(intent)
                                                Log.e(TAG, count.toString())
                                            } else {
                                                Toast.makeText(
                                                    this,
                                                    it.exception.toString(),
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                }
                                if (freequency.equals("Weekly Four Times (W4)")) {
                                    if (count != 4) {
                                        Toast.makeText(
                                            this,
                                            "Please Select Four Days",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        val databaseRef = database.reference.child("bookings")
                                            .child(firebaseauth.currentUser!!.uid)
                                        val bookings: Bookings = Bookings(
                                            startdate,
                                            apartmentsize,
                                            freequency,
                                            days,
                                            shift,
                                            allocatedMaid,
                                            allotedMaidId,
                                            allocatedMaid1,
                                            allotedMaidId1,
                                            noofdays,
                                            uid
                                        )
                                        databaseRef.setValue(bookings).addOnCompleteListener {
                                            if (it.isSuccessful) {
                                                Toast.makeText(
                                                    this,
                                                    "Service Scheduled Successfully",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                val intent = Intent(this, Cart::class.java)
                                                startActivity(intent)
                                                Log.e(TAG, count.toString())
                                            } else {
                                                Toast.makeText(
                                                    this,
                                                    it.exception.toString(),
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                }
                                if (freequency.equals("Weekly Three Times (W3)")) {
                                    if (count != 3) {
                                        Toast.makeText(
                                            this,
                                            "Please Select Three Days",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        val databaseRef = database.reference.child("bookings")
                                            .child(firebaseauth.currentUser!!.uid)
                                        val bookings: Bookings = Bookings(
                                            startdate,
                                            apartmentsize,
                                            freequency,
                                            days,
                                            shift,
                                            allocatedMaid,
                                            allotedMaidId,
                                            allocatedMaid1,
                                            allotedMaidId1,
                                            noofdays,
                                            uid
                                        )
                                        databaseRef.setValue(bookings).addOnCompleteListener {
                                            if (it.isSuccessful) {
                                                Toast.makeText(
                                                    this,
                                                    "Service Scheduled Successfully",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                val intent = Intent(this, Cart::class.java)
                                                startActivity(intent)
                                                Log.e(TAG, count.toString())
                                            } else {
                                                Toast.makeText(
                                                    this,
                                                    it.exception.toString(),
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                }
                                if (freequency.equals("Weekly Two Times (W2)")) {
                                    if (count != 2) {
                                        Toast.makeText(
                                            this,
                                            "Please Select Two Days",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        val databaseRef = database.reference.child("bookings")
                                            .child(firebaseauth.currentUser!!.uid)
                                        val bookings: Bookings = Bookings(
                                            startdate,
                                            apartmentsize,
                                            freequency,
                                            days,
                                            shift,
                                            allocatedMaid,
                                            allotedMaidId,
                                            allocatedMaid1,
                                            allotedMaidId1,
                                            noofdays,
                                            uid
                                        )
                                        databaseRef.setValue(bookings).addOnCompleteListener {
                                            if (it.isSuccessful) {
                                                Toast.makeText(
                                                    this,
                                                    "Service Scheduled Successfully",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                val intent = Intent(this, Cart::class.java)
                                                startActivity(intent)
                                                Log.e(TAG, count.toString())
                                            } else {
                                                Toast.makeText(
                                                    this,
                                                    it.exception.toString(),
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                }
                                if (freequency.equals("Weekly One Time (W1)")) {
                                    if (count != 1) {
                                        Toast.makeText(
                                            this,
                                            "Please Select One Days",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        val databaseRef = database.reference.child("bookings")
                                            .child(firebaseauth.currentUser!!.uid)
                                        val bookings: Bookings = Bookings(
                                            startdate,
                                            apartmentsize,
                                            freequency,
                                            days,
                                            shift,
                                            allocatedMaid,
                                            allotedMaidId,
                                            allocatedMaid1,
                                            allotedMaidId1,
                                            noofdays,
                                            uid
                                        )
                                        databaseRef.setValue(bookings).addOnCompleteListener {
                                            if (it.isSuccessful) {
                                                Toast.makeText(
                                                    this,
                                                    "Service Scheduled Successfully",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                val intent = Intent(this, Cart::class.java)
                                                startActivity(intent)
                                                Log.e(TAG, count.toString())
                                            } else {
                                                Toast.makeText(
                                                    this,
                                                    it.exception.toString(),
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                }

                            } else {
                                Toast.makeText(
                                    this,
                                    "Select your convinient shift",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        } else {
                            Toast.makeText(
                                this,
                                "Select your convinient freequency",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    } else {
                        Toast.makeText(this, "Select your apartment size", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(this, "Select your start date", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }















