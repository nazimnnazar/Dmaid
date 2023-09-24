package com.example.dmaid.Activity

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dmaid.*
import com.example.dmaid.Adapter.AdminHomeAdapter
import com.example.dmaid.R
import com.example.dmaid.databinding.ActivityAdminHomeBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class AdminHome : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAdminHomeBinding

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var heading: TextView
    private lateinit var empList: ArrayList<DateWiseBookings>
    private lateinit var dbRef: DatabaseReference

    private lateinit var dateToStr: String
    private lateinit var uid1: Array<String>
    private lateinit var uid: String

    private lateinit var stmaid :String
    private lateinit var stmaidid :String
    private lateinit var stmaid2 :String
    private lateinit var stmaidid2 :String

    private lateinit var date1: String
    private lateinit var date2: String
    private lateinit var date21: String
    private lateinit var date3: String
    private lateinit var date31: String
    private lateinit var date4: String
    private lateinit var date41: String
    private lateinit var date5: String
    private lateinit var date51: String
    private lateinit var date6: String
    private lateinit var date61: String
    private lateinit var date7: String
    private lateinit var date71: String
    private lateinit var date8: String
    private lateinit var date81: String
    private lateinit var date9: String
    private lateinit var date91: String
    private lateinit var date10: String
    private lateinit var date101: String
    private lateinit var date11: String
    private lateinit var date111: String
    private lateinit var date12: String
    private lateinit var date121: String





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





        val today = Date()
        val format = SimpleDateFormat("dd-MM-yyyy")
        val outformat = SimpleDateFormat("MMM d EEE")
         dateToStr= format.format(today)

        Log.e(TAG,dateToStr)

        try {

            val myDate = format.parse(dateToStr)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date1 = format.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date1)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date2 = format.format(newDate)
            date21 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }


        try {

            val myDate = format.parse(date2)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date3 = format.format(newDate)
            date31 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date3)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date4 = format.format(newDate)
            date41 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date4)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date5 = format.format(newDate)
            date51 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date5)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date6 = format.format(newDate)
            date61 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date6)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date7 = format.format(newDate)
            date71 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date7)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date8 = format.format(newDate)
            date81 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date8)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date9 = format.format(newDate)
            date91 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date9)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date10 = format.format(newDate)
            date101 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date10)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date11 = format.format(newDate)
            date111 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }

        try {

            val myDate = format.parse(date11)
            val c = Calendar.getInstance()
            c.time = myDate
            c[Calendar.DAY_OF_YEAR] = c[Calendar.DAY_OF_YEAR] + 1
            val newDate = c.time
            date12 = format.format(newDate)
            date121 = outformat.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            //handle exception
        }






        firebaseAuth = FirebaseAuth.getInstance()

        binding = ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarAdminHome.toolbar)


        empRecyclerView = findViewById(R.id.rvEmp)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)
        heading = findViewById(R.id.textView12)

        empList = arrayListOf<DateWiseBookings>()

        val zonesRef = FirebaseDatabase.getInstance().getReference("users")


        zonesRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (zoneSnapshot in dataSnapshot.children) {
                  uid = zoneSnapshot.child("uid").getValue(String::class.java).toString()

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException())
            }
        })






                    getTodayData()









        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_admin_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.add_aprt -> {
                    val Intent = Intent(this, AdminAddApartment::class.java)
                    startActivity(Intent)
                }
                R.id.add_maid -> {
                    val Intent = Intent(this, AdminMaids::class.java)
                    startActivity(Intent)
                }
                R.id.view_maid -> {
                    val Intent = Intent(this, AdminViewMaids::class.java)
                    startActivity(Intent)
                }
                R.id.home -> {
                    val Intent = Intent(this, AdminHome::class.java)
                    startActivity(Intent)
                }
                R.id.view_aprt -> {
                    val Intent = Intent(this, AdminViewApartments::class.java)
                    startActivity(Intent)
                }
                R.id.view_cust -> {
                    val Intent = Intent(this, AdminViewCustomers::class.java)
                    startActivity(Intent)
                }
                R.id.add_cust -> {
                    val Intent = Intent(this, AdminAddCustomer::class.java)
                    startActivity(Intent)
                }



                }
                true

            }


        }

    private fun getTodayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(dateToStr)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                         val   uuid = empList[position].dcustomerid



                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()



                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "Today's Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.admin_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.signout -> {
                   firebaseAuth.signOut()
                val Intent = Intent(this, First::class.java)
                startActivity(Intent)


                true
            }
            R.id.action_sort -> {
                sortDialog()



                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sortDialog() {
        val option = arrayOf("Today","Tomorrow",date21,date31,date41,date51,date61,date71,date81,date91,date101,date111,date121)

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Sort By..")
            .setItems(option) { dialoInterface , i ->
                if (i == 0)
                {
                   dialoInterface.dismiss()


                                getTodayData()

                }
                else if (i == 1)
                {
                    dialoInterface.dismiss()

                                get2DayData()

                }
                else if (i == 2)
                {
                    dialoInterface.dismiss()

                                get3DayData()

                }
                else if (i == 3)
                {
                    dialoInterface.dismiss()


                                get4DayData()

                }
                else if (i == 4)
                {
                    dialoInterface.dismiss()

                                get5DayData()

                }
                else if (i == 5)
                {
                    dialoInterface.dismiss()

                                get6DayData()

                }
                else if (i == 6)
                {
                    dialoInterface.dismiss()

                                get7DayData()

                }
                else if (i == 7)
                {
                    dialoInterface.dismiss()


                                get8DayData()

                }
                else if (i == 8)
                {
                    dialoInterface.dismiss()


                                get9DayData()

                }
                else if (i == 9)
                {
                    dialoInterface.dismiss()

                                get10DayData()

                }
                else if (i == 10)
                {
                    dialoInterface.dismiss()

                                get11DayData()

                }
                else if (i == 11)
                {
                    dialoInterface.dismiss()

                                get12DayData()

                }
                else if (i == 12)
                {
                    dialoInterface.dismiss()


                                get13DayData()

                }

            }.show()
    }

    private fun get13DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date121 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date12)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date121 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get12DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date111 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date11)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date111 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get11DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date101 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date10)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date101 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get10DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date91 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date9)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date91 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get9DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date81 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date8)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date81 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get8DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date71 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date7)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date71 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get7DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date61 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date6)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date61 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get6DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date51 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date5)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date51 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get5DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date41 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date4)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date41 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get4DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date31 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date3)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date31 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get3DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "$date21 Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date2)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "$date21 Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun get2DayData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        heading.text = "Tomorrow's Schedules"

        val dbRef1 = FirebaseDatabase.getInstance().getReference("datewisebookings")
            .orderByChild("ddate").equalTo(date1)

        dbRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DateWiseBookings::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = AdminHomeAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : AdminHomeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {





                            val   uuid = empList[position].dcustomerid

                            val bookingsRef1 = FirebaseDatabase.getInstance().getReference("bookings")
                            val bookings1Ref1 = bookingsRef1.child(uuid!!)


                            bookings1Ref1.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    stmaid = dataSnapshot.child("allocatedMaid").getValue(String::class.java).toString()
                                    stmaidid = dataSnapshot.child("allotedMaidId").getValue(String::class.java).toString()
                                    stmaid2 = dataSnapshot.child("allocatedMaid1").getValue(String::class.java).toString()
                                    stmaidid2 = dataSnapshot.child("allotedMaidId1").getValue(String::class.java).toString()


                                    val intent = Intent(this@AdminHome, DateWiseBookingDetails::class.java)
                                    intent.putExtra("dbid", empList[position].dbid)
                                    intent.putExtra("ddate", empList[position].ddate)
                                    intent.putExtra("dshift", empList[position].dshift)
                                    intent.putExtra("dcustomername", empList[position].dcustomername)
                                    intent.putExtra("dcustomerid", empList[position].dcustomerid)
                                    intent.putExtra("ddoorNo", empList[position].ddoorNo)
                                    intent.putExtra("dmaid", stmaid)
                                    intent.putExtra("dmaidid", stmaidid)
                                    intent.putExtra("dmaid2", stmaid2)
                                    intent.putExtra("dmaidid2", stmaidid2)
                                    intent.putExtra("dstatus", empList[position].dstatus)

                                    startActivity(intent)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Log.w(TAG, "onCancelled", databaseError.toException())
                                }
                            })



                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
                else{
                    tvLoadingData.text = "Tomorrow's Schedules Are Empty..!"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_admin_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}