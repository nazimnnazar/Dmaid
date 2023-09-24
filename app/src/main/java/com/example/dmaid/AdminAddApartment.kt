package com.example.dmaid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AdminAddApartment : AppCompatActivity() {

    private  lateinit var apName: EditText
    private  lateinit var apArea: EditText
    private  lateinit var apCity: EditText
    private  lateinit var apPin: EditText
    private  lateinit var apCluster: EditText
    private lateinit var addAp: Button
    private lateinit var viewAp: Button

    private lateinit var database: FirebaseDatabase
    private lateinit var firebaseauth: FirebaseAuth
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_add_apartment)

        database = FirebaseDatabase.getInstance()
        firebaseauth = FirebaseAuth.getInstance()
        apName = findViewById(R.id.edittext_ap)
        apArea = findViewById(R.id.aparea)
        apCity = findViewById(R.id.apcity)
        apPin = findViewById(R.id.appin)
        addAp = findViewById(R.id.add_apartment)
        viewAp = findViewById(R.id.view_apartment)

        apCluster = findViewById(R.id.apcluster)

        dbRef = FirebaseDatabase.getInstance().getReference("apartments")


        viewAp.setOnClickListener {
            val Intent = Intent(this, AdminViewApartments::class.java)
            startActivity(Intent)
        }


        addAp.setOnClickListener {
            saveMaidData()
        }

    }

    private fun saveMaidData() {
        val apartmentname = apName.text.toString()
        val cluster = apCluster.text.toString()
        val area = apArea.text.toString()
        val city = apCity.text.toString()
        val pin = apPin.text.toString()


        if (apartmentname.isNotEmpty()) {
            if (area.isNotEmpty()) {
                if (city.isNotEmpty()) {
                    if (pin.isNotEmpty()) {
                        if (cluster.isNotEmpty()) {
                        val apid = dbRef.push().key!!
                        val apartment = Apartments(apid, apartmentname,cluster, area, city, pin)

                        dbRef.child(apid).setValue(apartment)
                            .addOnCompleteListener {
                                Toast.makeText(
                                    this,
                                    "Apartment added successfully",
                                    Toast.LENGTH_LONG
                                ).show()

                                apName.text.clear()
                                apArea.text.clear()
                                apCity.text.clear()
                                apPin.text.clear()
                                apCluster.text.clear()

                            }.addOnFailureListener { err ->
                                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG)
                                    .show()
                            }
                        } else {
                            apPin.error = "Please enter cluster"
                        }
                    } else {
                        apPin.error = "Please enter pin"
                    }
                } else {
                    apCity.error = "Please enter city"
                }
            } else {
                apArea.error = "Please enter area"
            }
        } else {
            apName.error = "Please enter name"
        }
    }
}

