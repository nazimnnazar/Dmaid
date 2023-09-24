package com.example.dmaid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class ApartmentDetails : AppCompatActivity() {

    private lateinit var tvname: TextView
    private lateinit var tvarea: TextView
    private lateinit var tvcity: TextView
    private lateinit var tvPin: TextView
    private lateinit var tvCluster: TextView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apartment_details)

        initView()
        setValuesToViews()

        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("apid").toString(),
                intent.getStringExtra("apartmentname").toString()
            )
        }

        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("apid").toString()
            )
        }
    }

    private fun openUpdateDialog(apid: String, apartmentname: String) {

        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.update_apartment, null)

        mDialog.setView(mDialogView)

        val etName = mDialogView.findViewById<EditText>(R.id.apname)
        val etArea = mDialogView.findViewById<EditText>(R.id.aparea)
        val etCity = mDialogView.findViewById<EditText>(R.id.apcity)
        val etPin = mDialogView.findViewById<EditText>(R.id.appin)
        val etCluster = mDialogView.findViewById<EditText>(R.id.apcluster)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)

        etName.setText(intent.getStringExtra("apartmentname").toString())
        etArea.setText(intent.getStringExtra("area").toString())
        etCity.setText(intent.getStringExtra("city").toString())
        etPin.setText(intent.getStringExtra("pin").toString())
        etCluster.setText(intent.getStringExtra("cluster").toString())

        mDialog.setTitle("Updating $apartmentname Record")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {
            updateApartmentData(
                apid,
                etName.text.toString(),
                etCluster.text.toString(),
                etArea.text.toString(),
                etCity.text.toString(),
                etPin.text.toString()
            )

            Toast.makeText(applicationContext, "Apartment Data Updated", Toast.LENGTH_LONG).show()

            //we are setting updated data to our textviews
            tvname.text = etName.text.toString()
            tvarea.text = etArea.text.toString()
            tvcity.text = etCity.text.toString()
            tvPin.text = etPin.text.toString()
            tvCluster.text = etCluster.text.toString()

            alertDialog.dismiss()
        }
    }

    private fun updateApartmentData(
        apid: String,
        apartmentname: String,
        cluster: String,
        area: String,
        city: String,
        pin: String)
    {
        val dbRef = FirebaseDatabase.getInstance().getReference("apartments").child(apid)
        val empInfo = Apartments(apid, apartmentname,cluster, area, city, pin)
        dbRef.setValue(empInfo)
    }


    private fun deleteRecord(apid: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("apartments").child(apid)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "Apartment data deleted", Toast.LENGTH_LONG).show()

            val intent = Intent(this, AdminViewApartments::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{ error ->
            Toast.makeText(this, "Deleting failed due to ${error.message}", Toast.LENGTH_LONG).show()
        }
    }


    private fun setValuesToViews() {
        tvname.text = intent.getStringExtra("apartmentname")
        tvCluster.text = intent.getStringExtra("cluster")
        tvarea.text = intent.getStringExtra("area")
        tvcity.text = intent.getStringExtra("city")
        tvPin.text = intent.getStringExtra("pin")
    }

    private fun initView() {
        tvname = findViewById(R.id.tvEmpId)
        tvarea = findViewById(R.id.tvEmpName)
        tvcity = findViewById(R.id.tvEmpAge)
        tvPin = findViewById(R.id.tvEmpSalary)
        tvCluster = findViewById(R.id.tvCluster)

        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }
}