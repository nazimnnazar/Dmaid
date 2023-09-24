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
import com.example.dmaid.Activity.Home
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.*

class DateWiseBookingDetails : AppCompatActivity() {

    private lateinit var tvdate: TextView
    private lateinit var tvshift: TextView
    private lateinit var tvcustname: TextView
    private lateinit var tvmaidname: TextView
    private lateinit var tvmaidname2: TextView
    private lateinit var tvstatus: TextView

    private lateinit var btnAllocate: Button
    private lateinit var btnUpdateMaid: Button
    private lateinit var btnUpdateStatus: Button

    private lateinit var date1 :String
    private lateinit var uid: String
    private lateinit var dbid: String
    private lateinit var apartmentSize: String
    private  lateinit var noofdays: String

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

    private lateinit var ddate: String

    private lateinit var dateToStr: String
    private lateinit var date: String



    private  var subtotal : Float = 0.0f
    private  var nodays : Float = 0.0f
    private lateinit var spincent : String
    private lateinit var catey : String

    private lateinit var spincent1 : String
    private lateinit var catey1 : String

    private lateinit var tmaidid1: String
    private lateinit var tmaidid2: String
    var earnings = 0.00

    // var direarnings by Delegates.notNull<Int>()

    var direarnings2 = 0
    lateinit var direarnings3 :String
    lateinit var catearnings3 :String
    var spearnings = 0
    var catearnings = 0
    var catearnings1 = 0
    var price =  0
    private var earnPerDay:Float =0.0f

    lateinit var direarnings23 :String
    lateinit var catearnings23 :String

    lateinit var attendance3 :String
    lateinit var attendance23 :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_wise_booking_details)

        uid = intent.getStringExtra("dcustomerid").toString()
        dbid = intent.getStringExtra("dbid").toString()
        ddate= intent.getStringExtra("ddate").toString()

        initView()
        setValuesToViews()


        val today = Date()
        val format = SimpleDateFormat("dd-MM-yyyy")
        val outformat = SimpleDateFormat("MMM d EEE")
        dateToStr= format.format(today)


        if(tvstatus.text.equals("Completed")){
            btnUpdateStatus.isEnabled = false

        }





        val bookingsRef = FirebaseDatabase.getInstance().getReference("bookings")
        val bookings1Ref = bookingsRef.child(uid)


        bookings1Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                apartmentSize =
                    dataSnapshot.child("apartmentsize").getValue(String::class.java).toString()
                noofdays= dataSnapshot.child("freequency").getValue(String::class.java)!!.toString()

                if (apartmentSize.equals("3BHK")||apartmentSize.equals("4BHK")||apartmentSize.equals("5BHK")||apartmentSize.equals("6BHK")){
                    if (noofdays.equals("Weekly One Time (W1)")){
                        earnPerDay = 550.0F

                    }
                    else if(noofdays.equals("Weekly Two Times (W2)")){
                        earnPerDay = 450.0F
                    }
                    else if(noofdays.equals("Weekly Three Times (W3)")){
                        earnPerDay = 365.0F
                    }
                    else if(noofdays.equals("Weekly Four Times (W4)")){
                        earnPerDay = 350.0F
                    }
                    else if(noofdays.equals("Weekly Five Times (W5)")){
                        earnPerDay = 335.0F
                    }
                    else if(noofdays.equals("Weekly Six Times (W6")||nodays.equals("Daily")){
                        earnPerDay = 335.0F
                    }
                }
                else if (apartmentSize.equals("2BHK")||apartmentSize.equals("1BHK")){
                    if (noofdays.equals("Weekly One Time (W1)")){
                        earnPerDay = 500.0F
                    }
                    else if(noofdays.equals("Weekly Two Times (W2)")){
                        earnPerDay = 400.0F
                    }
                    else if(noofdays.equals("Weekly Three Times (W3)")){
                        earnPerDay = 325.0F
                    }
                    else if(noofdays.equals("Weekly Four Times (W4)")){
                        earnPerDay = 315.0F
                    }
                    else if(noofdays.equals("Weekly Five Times (W5)")){
                        earnPerDay = 300.0F
                    }
                    else if(noofdays.equals("Weekly Six Times (W6)") || nodays.equals("Daily")){
                        earnPerDay = 300.0F
                    }


                    if (apartmentSize == "4BHK" || apartmentSize == "5BHK" || apartmentSize == "6BHK")
                    {
                        tvmaidname2.visibility = View.VISIBLE
                    }

                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
            }
        })


        btnAllocate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("dbid").toString()
            )
        }

        btnUpdateMaid.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("dbid").toString()
            )
        }

        btnUpdateStatus.setOnClickListener {
            openUpdateStatusDialog(
                intent.getStringExtra("dbid").toString()

            )
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





            val bookingsRef = FirebaseDatabase.getInstance().getReference("maids")
            val bookings1Ref = bookingsRef.child(tmaidid1)
            bookings1Ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        catey =
                            dataSnapshot.child("category").getValue(String::class.java).toString()
                        Log.e(TAG,"category is $catey")
                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                }
            })



            val b1 = FirebaseDatabase.getInstance().getReference("paymentdetails")
            val bo1 = b1.child(uid)
            bo1.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        subtotal = dataSnapshot.child("psubtotal").getValue(String::class.java)!!.toFloat()

                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                }
            })


            val n12 = FirebaseDatabase.getInstance().getReference("maids")
            val nn12 = n12.child(tmaidid1)
            nn12.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        spincent =
                            dataSnapshot.child("specialIncentive").getValue(String::class.java).toString()
                        catey =
                            dataSnapshot.child("category").getValue(String::class.java).toString()

                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                }
            })



        }







    }

    private fun openUpdateStatusDialog(dbid: String) {
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.update_status, null)

        mDialog.setView(mDialogView)

        val status = mDialogView.findViewById<CheckBox>(R.id.chstatus)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)



        mDialog.setTitle("Update Status")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {

            val ref = FirebaseDatabase.getInstance().reference.child("datewisebookings").child(dbid)
            val updates: MutableMap<String, Any> = HashMap()

            if (status.isChecked) {
                updates["dstatus"] = "Completed"
            }

            val today = Date()
            val outformat = SimpleDateFormat("yyyy-MM")
            val date1 = SimpleDateFormat("dd")
            dateToStr= outformat.format(today)
            date = date1.format(today)

            if(tmaidid2.isEmpty()) {
                val ref1 =
                    FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr)
                        .child(date).child(tmaidid1)
                val updates1: MutableMap<String, Any> = HashMap()
                earnings = earnPerDay.toDouble() * 0.5

                Log.e(ContentValues.TAG, earnings.toString())
                updates1["Base_earning"] = earnings
                updates1["direct_earnings"] = earnings

                ref1.updateChildren(updates1)
                val ref12 =
                    FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr)
                        .child(tmaidid1)
                val updates12: MutableMap<String, Any> = HashMap()


                Log.e(ContentValues.TAG, earnings.toString())


                updates12["Base_earning"] = earnings
                updates12["noofdays"] = nodays

                ref12.updateChildren(updates12)
            }

            val ref1 =
                FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr)
                    .child(date).child(tmaidid1)
            val updates1: MutableMap<String, Any> = HashMap()
            earnings = earnPerDay.toDouble() * 0.5

            Log.e(ContentValues.TAG, earnings.toString())
            updates1["Base_earning"] = earnings
            updates1["direct_earnings"] = earnings

            ref1.updateChildren(updates1)
            val ref12 =
                FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr)
                    .child(tmaidid1)
            val updates12: MutableMap<String, Any> = HashMap()


            Log.e(ContentValues.TAG, earnings.toString())


            updates12["Base_earning"] = earnings
            updates12["noofdays"] = nodays

            ref12.updateChildren(updates12)


            val n13 = FirebaseDatabase.getInstance().getReference("maidearnings")
            val nn13 = n13.child(dateToStr).child(date).child(tmaidid1).child("direct_earnings")
            nn13.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        var direarnings =
                            dataSnapshot.getValue(Long::class.java)!!.toInt()

                        val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(tmaidid1)
                        val updates1: MutableMap<String, Any> = HashMap()

                        updates1["direct_earnings"] = earnPerDay * 0.5
                        updates1["base_earnings"] = earnPerDay* 0.5
                        updates1["noofdays"] = nodays
                        ref1.updateChildren(updates1)



                    }
                    else{
                        var direarnings = 0


                        val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(tmaidid1)
                        val updates1: MutableMap<String, Any> = HashMap()

                        updates1["direct_earnings"] = earnPerDay
                        updates1["base_earnings"] = earnPerDay
                        updates1["noofdays"] = nodays


                        ref1.updateChildren(updates1)

                    }

                }
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                }
            })

            val at1 = FirebaseDatabase.getInstance().getReference("maidearnings")
            val att1 = at1.child(dateToStr).child(date).child(tmaidid1).child("Attendance_incentive")
            att1.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        var attendance =
                            dataSnapshot.getValue(Long::class.java)!!.toInt()


                        val atp1: Float = subtotal / nodays
                        val atp2: Float = atp1 / 2
                        val atp13: Double = atp2 * 0.20
                        val atp3 = atp13 / 10


                        attendance3 = attendance.toString()
                        val dir =  atp3.toFloat() + attendance3.toInt()

                        Log.e(TAG, attendance.toString())

                        val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(tmaidid1)
                        val updates1: MutableMap<String, Any> = HashMap()

                        updates1["Attendance_incentive"] = dir.toInt()

                        ref1.updateChildren(updates1)

                    }
                    else{
                        var attendance = 0

                        val atp1: Float = subtotal / nodays
                        val atp2: Float = atp1 / 2
                        val atp13: Double = atp2 * 0.20
                        val atp3 = atp13 / 10
                        attendance23 = attendance.toString()
                        val dir =  atp3.toFloat() + attendance23.toInt()

                        Log.e(TAG, atp3.toString())

                        val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(tmaidid1)
                        val updates1: MutableMap<String, Any> = HashMap()

                        updates1["Attendance_incentive"] = dir.toInt()

                        ref1.updateChildren(updates1)

                    }

                }
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                }
            })






            /* if (tmaidid1.isNotEmpty())
             {
                 if(catey.equals("3 Services/Day"))
                 {
                     val n13 = FirebaseDatabase.getInstance().getReference("maidearnings")
                     val nn13 = n13.child(dateToStr).child(date).child(tmaidid1).child("category_incentive")
                     nn13.addListenerForSingleValueEvent(object : ValueEventListener {
                         override fun onDataChange(dataSnapshot: DataSnapshot) {
                             if (dataSnapshot.exists()) {
                                 var catearnings =
                                     dataSnapshot.getValue(Long::class.java)!!.toInt()


                                 val price: Float = subtotal / nodays
                                 val amount: Double = price * 0.03
                                 catearnings3 = catearnings.toString()
                                 val dir = amount.toFloat() + catearnings3.toInt()


                                 Log.e(TAG, catearnings.toString())

                                 val ref2 =
                                     FirebaseDatabase.getInstance().reference.child("maidearnings")
                                         .child(dateToStr).child(date).child(tmaidid1)
                                 val updates2: MutableMap<String, Any> = HashMap()

                                 updates2["category_incentive"] = dir.toInt()


                                 ref2.updateChildren(updates2)


                             } else {
                                 var catearnings = 0

                                 val price: Float = subtotal / nodays
                                 val amount: Double = price * 0.03
                                 catearnings23 = catearnings.toString()
                                 val dir = amount.toFloat() + catearnings23.toInt()

                                 Log.e(TAG, amount.toString())

                                 val ref2 =
                                     FirebaseDatabase.getInstance().reference.child("maidearnings")
                                         .child(dateToStr).child(date).child(tmaidid1)
                                 val updates2: MutableMap<String, Any> = HashMap()

                                 updates2["category_incentive"] = dir.toInt()

                                 ref2.updateChildren(updates2)

                             }

                         }

                         override fun onCancelled(databaseError: DatabaseError) {
                             Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                         }
                     })

                 }
             }



             if (tmaidid2.isNotEmpty())
             {

                 val n13 = FirebaseDatabase.getInstance().getReference("maidearnings")
                 val nn13 = n13.child(dateToStr).child(date).child(tmaidid2).child("direct_earnings")
                 nn13.addListenerForSingleValueEvent(object : ValueEventListener {
                     override fun onDataChange(dataSnapshot: DataSnapshot) {
                         if (dataSnapshot.exists()) {
                             var direarnings =
                                 dataSnapshot.getValue(Long::class.java)!!.toInt()


                             val price: Float = subtotal / nodays
                             val amount: Float = price / 2
                             direarnings3 = direarnings.toString()
                             val dir =  amount.toFloat() + direarnings3.toInt()

                             direarnings2 = amount.toInt()

                             Log.e(TAG, direarnings.toString())

                             val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(tmaidid2)
                             val updates1: MutableMap<String, Any> = HashMap()

                             updates1["direct_earnings"] = dir.toInt()
                             updates1["base_earnings"] = direarnings2
                             updates1["noofdays"] = nodays

                             ref1.updateChildren(updates1)



                         }
                         else{
                             var direarnings = 0

                             val price: Float = subtotal / nodays
                             val amount: Float = price / 2
                             direarnings23 = direarnings.toString()
                             val dir =  amount.toFloat() + direarnings23.toInt()

                             direarnings2 = amount.toInt()

                             Log.e(TAG, amount.toString())

                             val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(tmaidid2)
                             val updates1: MutableMap<String, Any> = HashMap()

                             updates1["direct_earnings"] = dir.toInt()
                             updates1["base_earnings"] = direarnings2
                             updates1["noofdays"] = nodays

                             ref1.updateChildren(updates1)

                         }

                     }
                     override fun onCancelled(databaseError: DatabaseError) {
                         Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                     }
                 })

                 val at1 = FirebaseDatabase.getInstance().getReference("maidearnings")
                 val att1 = at1.child(dateToStr).child(date).child(tmaidid2).child("Attendance_incentive")
                 att1.addListenerForSingleValueEvent(object : ValueEventListener {
                     override fun onDataChange(dataSnapshot: DataSnapshot) {
                         if (dataSnapshot.exists()) {
                             var attendance =
                                 dataSnapshot.getValue(Long::class.java)!!.toInt()


                             val atp1: Float = subtotal / nodays
                             val atp2: Float = atp1 / 2
                             val atp13: Double = atp2 * 0.20
                             val atp3 = atp13 / 10
                             attendance3 = attendance.toString()
                             val dir =  atp3.toFloat() + attendance3.toInt()

                             Log.e(TAG, attendance.toString())

                             val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(tmaidid2)
                             val updates1: MutableMap<String, Any> = HashMap()

                             updates1["Attendance_incentive"] = dir.toInt()

                             ref1.updateChildren(updates1)

                         }
                         else{
                             var attendance = 0

                             val atp1: Float = subtotal / nodays
                             val atp2: Float = atp1 / 2
                             val atp13: Double = atp2 * 0.20
                             val atp3 = atp13 / 10
                             attendance23 = attendance.toString()
                             val dir =  atp3.toFloat() + attendance23.toInt()

                             Log.e(TAG, atp3.toString())

                             val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(date).child(tmaidid2)
                             val updates1: MutableMap<String, Any> = HashMap()

                             updates1["Attendance_incentive"] = dir.toInt()

                             ref1.updateChildren(updates1)

                         }

                     }
                     override fun onCancelled(databaseError: DatabaseError) {
                         Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                     }
                 })


             }

 Log.e(TAG,tmaidid2)

             if (tmaidid2.equals(" "))
             {

                 val bookingsRe = FirebaseDatabase.getInstance().getReference("maids")
                 val bookings1Re = bookingsRe.child(tmaidid2)
                 bookings1Re.addValueEventListener(object : ValueEventListener {
                     override fun onDataChange(dataSnapshot: DataSnapshot) {
                         if (dataSnapshot.exists()) {
                             catey1 =
                                 dataSnapshot.child("category").getValue(String::class.java).toString()
                             Log.e(TAG,"category is $catey1")


                             if(catey1.equals("3 Services/Day"))
                             {
                                 val n13 = FirebaseDatabase.getInstance().getReference("maidearnings")
                                 val nn13 = n13.child(dateToStr).child(date).child(tmaidid2).child("category_incentive")
                                 nn13.addListenerForSingleValueEvent(object : ValueEventListener {
                                     override fun onDataChange(dataSnapshot: DataSnapshot) {
                                         if (dataSnapshot.exists()) {
                                             var catearnings =
                                                 dataSnapshot.getValue(Long::class.java)!!.toInt()


                                             val price: Float = subtotal / nodays
                                             val amount: Double = price * 0.03
                                             catearnings3 = catearnings.toString()
                                             val dir = amount.toFloat() + catearnings3.toInt()


                                             Log.e(TAG, catearnings.toString())

                                             val ref2 =
                                                 FirebaseDatabase.getInstance().reference.child("maidearnings")
                                                     .child(dateToStr).child(date).child(tmaidid2)
                                             val updates2: MutableMap<String, Any> = HashMap()

                                             updates2["category_incentive"] = dir.toInt()


                                             ref2.updateChildren(updates2)


                                         } else {
                                             var catearnings = 0

                                             val price: Float = subtotal / nodays
                                             val amount: Double = price * 0.03
                                             catearnings23 = catearnings.toString()
                                             val dir = amount.toFloat() + catearnings23.toInt()

                                             Log.e(TAG, amount.toString())

                                             val ref2 =
                                                 FirebaseDatabase.getInstance().reference.child("maidearnings")
                                                     .child(dateToStr).child(date).child(tmaidid2)
                                             val updates2: MutableMap<String, Any> = HashMap()

                                             updates2["category_incentive"] = dir.toInt()

                                             ref2.updateChildren(updates2)

                                         }

                                     }

                                     override fun onCancelled(databaseError: DatabaseError) {
                                         Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                                     }
                                 })

                             }
                         }
                     }
                     override fun onCancelled(databaseError: DatabaseError) {
                         Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                     }
                 })


             }*/


//etc
            Toast.makeText(this," updated", Toast.LENGTH_SHORT).show()

//etc
            ref.updateChildren(updates)

            tvstatus.text ="Completed"
            if(tvstatus.text.equals("Completed")){
                btnUpdateStatus.isEnabled = false

            }

            alertDialog.dismiss()
        }
    }

    private fun openUpdateDialog(dbid: String) {
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.allocate_maid_simple, null)

        mDialog.setView(mDialogView)

        val etMaid = mDialogView.findViewById<Spinner>(R.id.maidname)
        val selectmaid1 = mDialogView.findViewById<TextView>(R.id.maid2)
        val etMaid1 = mDialogView.findViewById<Spinner>(R.id.maidname1)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)

        val apart = apartmentSize


        if (apart == "4BHK" || apart == "5BHK" || apart == "6BHK") {

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
                        this@DateWiseBookingDetails,
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
                                    tmaidid1 = allotedMiad

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
                        this@DateWiseBookingDetails,
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
                        this@DateWiseBookingDetails,
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

        mDialog.setTitle("Allocating Maid")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {

            val ref = FirebaseDatabase.getInstance().reference.child("datewisebookings").child(dbid)
            val updates: MutableMap<String, Any> = HashMap()


            updates["dmaid"] = selected
            updates["dmaidid"] = allotedMiad

            updates["dmaid2"] = selected1

            updates["dmaidid2"] = allotedMiad1
            tmaidid1 = allotedMiad


//etc
            Toast.makeText(this," updated", Toast.LENGTH_SHORT).show()

//etc
            ref.updateChildren(updates)


            tvmaidname.text = selected
            tvmaidname2.text = selected1

            alertDialog.dismiss()
        }
    }

    private fun setValuesToViews() {
        tvdate.text = intent.getStringExtra("ddate")
        tvshift.text = intent.getStringExtra("dshift")
        tvcustname.text = intent.getStringExtra("dcustomername")
        tvmaidname.text = intent.getStringExtra("dmaid")
        tvmaidname2.text = intent.getStringExtra("dmaid2")
        tmaidid1 = intent.getStringExtra("dmaidid").toString()
        tmaidid2 = intent.getStringExtra("dmaidid2").toString()
        tvstatus.text = intent.getStringExtra("dstatus")
    }

    private fun initView() {
        tvdate = findViewById(R.id.tvDate)
        tvshift = findViewById(R.id.tvShift)
        tvcustname = findViewById(R.id.tvCustName)
        tvmaidname = findViewById(R.id.tvMaid1)
        tvmaidname2 = findViewById(R.id.tvmaid2)
        tvstatus = findViewById(R.id.tvStatus)

        btnAllocate = findViewById(R.id.btnAllocate)
        btnUpdateMaid = findViewById(R.id.UpdateMaid)
        btnUpdateStatus = findViewById(R.id.UpadteStatus)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, AdminHome::class.java)
        startActivity(intent)
        finish()
    }
}