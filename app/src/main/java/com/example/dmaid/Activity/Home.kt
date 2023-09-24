package com.example.dmaid.Activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.dmaid.R
import com.example.dmaid.Services
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class Home : AppCompatActivity() {

    private lateinit var profilepic: ImageView
    private lateinit var username: TextView
    private lateinit var addresss: TextView

    private lateinit var firebaseauth: FirebaseAuth
    private lateinit var backbtn: ImageView

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //getting id

        profilepic = findViewById(R.id.profile)
        username = findViewById(R.id.textView9)
        addresss = findViewById(R.id.textView11)

        firebaseauth = FirebaseAuth.getInstance()
        checkuser()

        backbtn = findViewById(R.id.backbtn)
        backbtn.setOnClickListener{
            onBackPressed()
        }


        val services = findViewById<TextView>(R.id.tv12)
        services.setOnClickListener {
            val Intent = Intent(this, Services::class.java)
            startActivity(Intent)
        }




        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout)



        profilepic.setOnClickListener{v->
            (applicationContext as Home).openCloseNavigationDrawer(v)
        }
        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button


        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun checkuser() {
        val ref = FirebaseDatabase.getInstance().getReference("users")
        ref.child(firebaseauth.uid!!)
            .addValueEventListener(object : ValueEventListener  {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val firstname = "${snapshot.child("firstname").value}"
                    val address = "${snapshot.child("address").value}"

                    username.text = firstname
                    addresss.text = address
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    fun openCloseNavigationDrawer(view: View) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}