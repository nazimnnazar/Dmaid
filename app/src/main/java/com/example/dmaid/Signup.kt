package com.example.dmaid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.Customer.PrivacyPolicy
import com.example.dmaid.Models.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class Signup : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase


    private lateinit var spinner: Spinner
    private lateinit var signupBtn: Button
    private lateinit var fname: EditText
    private lateinit var lname: EditText
    private lateinit var address: EditText
    private lateinit var pin: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cpassword: EditText
    private lateinit var familySize: EditText
    private lateinit var spouseName: EditText
    private lateinit var contactNum: EditText
    private lateinit var whatsappNum: EditText
    private lateinit var doorNo: EditText

    private lateinit var terms: TextView
    private lateinit var backarrow: ImageView

    private  lateinit var selected: String

    private lateinit var check: CheckBox


    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var profileImg: Uri
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        backarrow = findViewById(R.id.arrow)
        check = findViewById(R.id.checkBox)
        spinner = findViewById(R.id.apartmentspinner)
        signupBtn = findViewById(R.id.imageButton8)
        fname = findViewById(R.id.first_name)
        lname = findViewById(R.id.last_name)
        address = findViewById(R.id.address)
        pin = findViewById(R.id.pin)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        cpassword = findViewById(R.id.cpassword)
        familySize = findViewById(R.id.famsize)
        spouseName = findViewById(R.id.spouse_name)
        contactNum = findViewById(R.id.contactnum)
        whatsappNum = findViewById(R.id.whatsappnum)
        doorNo = findViewById(R.id.doorno)

        firebaseAuth = FirebaseAuth.getInstance()
    database = FirebaseDatabase.getInstance()

     terms = findViewById<Button>(R.id.textView16)
    terms.setOnClickListener {
        val Intent = Intent(this, PrivacyPolicy::class.java)
        startActivity(Intent)
    }

    backarrow.setOnClickListener {
        val Intent = Intent(this,First::class.java)
        startActivity(Intent)
    }



        val signin = findViewById<TextView>(R.id.tv1)
        signin.setOnClickListener {
            val Intent = Intent(this,Login::class.java)
            startActivity(Intent)



        }

        val dataref = database.getReference()

        dataref.child("apartments").addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // Is better to use a List, because you don't know the size
            // of the iterator returned by dataSnapshot.getChildren() to
            // initialize the array
            val apartments: MutableList<String> = ArrayList()
            for (addressSnapshot in dataSnapshot.children) {
                val propertyAddress = addressSnapshot.child("apartmentname").getValue(
                    String::class.java
                )
                if (propertyAddress != null) {
                    apartments.add(propertyAddress)
                }
            }

            val addressAdapter = ArrayAdapter(
                this@Signup,
                android.R.layout.simple_spinner_item,
                apartments
            )
            addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = addressAdapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selected = apartments[p2].toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }



        override fun onCancelled(databaseError: DatabaseError) {}
    })




    signupBtn.setOnClickListener {

        val firstname = fname.text.toString()
        val lastname = lname.text.toString()
        val address = address.text.toString()
        val pin = pin.text.toString()
        val apartment = selected
        val email = email.text.toString()
        val password = password.text.toString()
        val confirmPassword = cpassword.text.toString()
        val familysize = familySize.text.toString()
        val spousename = spouseName.text.toString()
        val doorNo = doorNo.text.toString()
        val contactnumber = contactNum.text.toString()
        val whatsappnumber = whatsappNum.text.toString()
        val profileimage = " "

        if (firstname.isNotEmpty() && lastname.isNotEmpty() && address.isNotEmpty() && familysize.isNotEmpty() && pin.isNotEmpty() && apartment.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && contactnumber.isNotEmpty() && doorNo.isNotEmpty() && whatsappnumber.isNotEmpty()) {
            if (password == confirmPassword) {
                if(check.isChecked) {


                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {

                            val databaseRef = database.reference.child("users")
                                .child(firebaseAuth.currentUser!!.uid)
                            val users: Users = Users(
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
                                firebaseAuth.currentUser!!.uid
                            )

                            databaseRef.setValue(users).addOnCompleteListener {
                                if (it.isSuccessful) {

                                    val intent = Intent(this, Login::class.java)
                                    startActivity(intent)
                                } else {

                                    Toast.makeText(
                                        this,
                                        it.exception.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                        } else {

                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                }
                else {

                    Toast.makeText(this, "Please accept the privacy and policy", Toast.LENGTH_SHORT).show()
                }
            } else {

                Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
            }
        } else {

            Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

        }
    }



}
}


















