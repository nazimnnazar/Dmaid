package com.example.dmaid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
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

    private lateinit var dateToStr: String

    private lateinit var ddate: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maid_view_booking_details)


        uid = intent.getStringExtra("dcustomerid").toString()
        dbid = intent.getStringExtra("dbid").toString()
        ddate= intent.getStringExtra("ddate").toString()

        initView()
        setValuesToViews()



        val today = Date()
        val format = SimpleDateFormat("dd-MM-yyyy")
        val outformat = SimpleDateFormat("MMM d EEE")
        dateToStr= format.format(today)


        if (ddate == dateToStr)
        {
            btnUpdateStatus.visibility = View.VISIBLE
        }
        else{
            btnUpdateStatus.visibility = View.INVISIBLE
        }





        btnUpdateStatus.setOnClickListener {
            openUpdateStatusDialog(
                intent.getStringExtra("dbid").toString()
            )
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



//etc
            Toast.makeText(this," updated", Toast.LENGTH_SHORT).show()

//etc
            ref.updateChildren(updates)

            tvstatus.text ="Completed"

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

}