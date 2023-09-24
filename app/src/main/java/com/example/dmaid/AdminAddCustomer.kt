package com.example.dmaid

import android.app.Activity
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Models.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import java.io.IOException

class AdminAddCustomer : AppCompatActivity() {

    private  lateinit var custFname: EditText
    private  lateinit var custLname: EditText
    private  lateinit var custAdress: EditText
    private  lateinit var custApartment: EditText
    private lateinit var custPin: EditText
    private lateinit var custEmail: EditText
    private  lateinit var custFamSize: EditText
    private  lateinit var custPass: EditText
    private lateinit var custSpouseName: EditText
    private lateinit var custDoorNo: EditText
    private  lateinit var custContactNumber: EditText
    private  lateinit var custWhatsappNumber: EditText

    private lateinit var addCust: Button
    private  lateinit var viewCust: Button

    private lateinit var database: FirebaseDatabase
    private lateinit var firebaseauth: FirebaseAuth
    private lateinit var dbRef: DatabaseReference
    private lateinit var storage: FirebaseStorage

    private lateinit var profileImg: Uri
    private lateinit var dialog: AlertDialog.Builder
    private  lateinit var proDp: ImageView
    private var filePath: Uri? = null

    private lateinit var progressDialog: ProgressDialog

    private lateinit var storageReference: StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_add_customer)


        database = FirebaseDatabase.getInstance()
        firebaseauth = FirebaseAuth.getInstance()

        custFname = findViewById(R.id.customerfirstname)
        custLname = findViewById(R.id.custlastname)
        custAdress = findViewById(R.id.cust)
        custApartment = findViewById(R.id.custapartment)
        custPin = findViewById(R.id.customerpin)
        custEmail = findViewById(R.id.customeremail)
        custFamSize = findViewById(R.id.customerfamsize)
        custPass = findViewById(R.id.customerpass)
        custSpouseName = findViewById(R.id.custspousename)
        custDoorNo = findViewById(R.id.custdoorno)
        custContactNumber = findViewById(R.id.custcontactnum)
        custWhatsappNumber = findViewById(R.id.custwhatsappnum)
        proDp = findViewById(R.id.tvpimg)

        progressDialog = ProgressDialog(this@AdminAddCustomer)
        progressDialog.setTitle("Customer data saving.....")
        progressDialog.setMessage("please wait....")

        addCust = findViewById(R.id.add_apartment)
        viewCust = findViewById(R.id.view_apartment)

        dbRef = FirebaseDatabase.getInstance().getReference("users")
        storage = FirebaseStorage.getInstance()



        dialog = AlertDialog.Builder(this)
            .setMessage("saving changes...")
            .setCancelable(false)


        viewCust.setOnClickListener {
            val Intent = Intent(this, AdminViewCustomers::class.java)
            startActivity(Intent)
        }


        proDp.setOnClickListener{
            selectImage()
        }


        addCust.setOnClickListener {
            saveCustomerData()
        }


    }

    private fun selectImage() {
        // Creating AlertDialog
        val choice = arrayOf<CharSequence>("Take Photo", "Choose from Gallery", "Cancel")
        val myAlertDialog: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        myAlertDialog.setTitle("Select Image")
        myAlertDialog.setCancelable(true)
        myAlertDialog.setItems(choice, DialogInterface.OnClickListener { dialog, item ->
            when {
                choice[item] == "Choose from Gallery" -> {
                    val intent = Intent()
                    intent.type = "image/*"
                    intent.action = Intent.ACTION_GET_CONTENT
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
                }
                choice[item] == "Take Photo" -> {
                    val cameraPicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(cameraPicture, 0)
                }

            }
        })
        myAlertDialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            0 -> if (resultCode == RESULT_OK && data != null) {
                val imageSelected = data.extras!!["data"] as Bitmap?
                proDp.setImageBitmap(imageSelected)
            }
        }

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if(data == null || data.data == null){
                return
            }

            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                proDp.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun saveCustomerData() {
        val firstname = custFname.text.toString()
        val lastname = custLname.text.toString()
        val address = custAdress.text.toString()
        val pin = custPin.text.toString()
        val apartment = custApartment.text.toString()
        val email = custEmail.text.toString()
        val password = custPass.text.toString()
        val familysize = custFamSize.text.toString()
        val spousename = custSpouseName.text.toString()
        val doorNo = custDoorNo.text.toString()
        val contactnumber = custContactNumber.text.toString()
        val whatsappnumber = custWhatsappNumber.text.toString()
        val profileimage = proDp.toString()




        if (email.isNotEmpty()) {
            if (password.isNotEmpty()) {
                progressDialog.show()
                val uid = dbRef.push().key!!
                if (profileimage.isEmpty()) {
                    proDp.setImageResource(R.drawable.ic_person_grey)
                } else {


                    val filepath6 =
                        "customerProfile/$uid/profileimg"
                    storageReference =
                        FirebaseStorage.getInstance()
                            .getReference(filepath6)
                    filePath?.let { it1 ->
                        storageReference.putFile(it1)
                            .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->
                                Log.e(
                                    this.localClassName,
                                    "image upload success..."
                                )




                            }.addOnFailureListener {
                                Log.e(
                                    this.localClassName,
                                    "image upload failed..."
                                )
                            }
                    }

                }


                val user = Users(
                    firstname,
                    lastname,
                    address,
                    pin,
                    apartment,
                    email,
                    profileimage,
                    familysize,
                    password,
                    spousename,
                    doorNo,
                    contactnumber,
                    whatsappnumber,
                    uid
                )


                dbRef.child(uid).setValue(user)
                    .addOnCompleteListener {

                        Toast.makeText(
                            this,
                            "Customer added successfully",
                            Toast.LENGTH_LONG
                        ).show()
                        progressDialog.dismiss()
                        custFname.text.clear()
                        custLname.text.clear()
                        custAdress.text.clear()
                        custPin.text.clear()
                        custSpouseName.text.clear()
                        custApartment.text.clear()
                        custEmail.text.clear()
                        custFamSize.text.clear()
                        custLname.text.clear()
                        custDoorNo.text.clear()
                        custContactNumber.text.clear()
                        custWhatsappNumber.text.clear()
                        custPass.text.clear()
                        proDp.setImageResource(R.drawable.ic_person_grey)


                    }.addOnFailureListener { err ->
                        Toast.makeText(
                            this,
                            "Error ${err.message}",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }


            } else {
                custPass.error = "Please enter the password"
            }

        } else {
            custEmail.error = "Please enter the email"
        }
    }




}
