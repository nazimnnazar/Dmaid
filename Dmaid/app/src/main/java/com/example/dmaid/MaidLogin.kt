package com.example.dmaid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dmaid.Activity.maid.Menupage
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MaidLogin : AppCompatActivity() {


    private lateinit var loginBtn: ImageButton
    private lateinit var username: EditText
    private lateinit var Pword: EditText

    private lateinit var maiduname: String
    private lateinit var maidpass: String
    private lateinit var maidid: String

    private lateinit var uname: String
    private lateinit var pass: String


    val namelist : ArrayList<String> = arrayListOf()
    val passwordlist : ArrayList<String> = arrayListOf()
    val idlist : ArrayList<String> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maid_login)

        username = findViewById(R.id.ed1)
        Pword = findViewById(R.id.ed2)

        loginBtn = findViewById(R.id.imageButton)


        uname = ""
        pass = ""




        val rootRef = FirebaseDatabase.getInstance().reference
        val usersdRef = rootRef.child("maids")
        val eventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ds in dataSnapshot.children) {
                     maidid =  ds.child("maidid").getValue(String::class.java).toString()
                     maiduname = ds.child("username").getValue(String::class.java).toString()
                     maidpass = ds.child("password").getValue(String::class.java).toString()

                    namelist.add(maiduname)
                    Log.e("TAG", namelist.toString())

                    passwordlist.add(maidpass)
                    Log.e("TAG", passwordlist.toString())

                    idlist.add(maidid)
                    Log.e("TAG", idlist.toString())
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        }
        usersdRef.addListenerForSingleValueEvent(eventListener)

        loginBtn.setOnClickListener {

            if (namelist.contains(username.text.toString()))
            {
                 uname = username.text.toString()
            }
            else {
                Toast.makeText(this, "Incorrect Username !!", Toast.LENGTH_SHORT).show()

            }


            if (passwordlist.contains(Pword.text.toString()))
            {
                pass = Pword.text.toString()
            }
            else {
                Toast.makeText(this, "Incorrect Password !!", Toast.LENGTH_SHORT).show()

            }


            if (uname.isNotEmpty() && pass.isNotEmpty()) {

                val intent = Intent(this@MaidLogin, Menupage::class.java)

                intent.putExtra("maidid",uname)
                intent.putExtra("password",pass)
                startActivity(intent)


            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }


        }



    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,First::class.java)
        startActivity(intent)
        finish()
    }
}