package com.example.dmaid

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColor
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dmaid.Activity.AdminHome
import com.example.dmaid.Activity.Customer.MyServices
import com.example.dmaid.Activity.Customer.PrivacyPolicy
import com.example.dmaid.Activity.Customer.Profile
import com.example.dmaid.databinding.ActivityCustomerHomeBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class CustomerHome : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCustomerHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustomerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarCustomerHome.toolbar)

        firebaseAuth = FirebaseAuth.getInstance()

        val services = findViewById<TextView>(R.id.textView12)
        services.setOnClickListener {
            val Intent = Intent(this,Services::class.java)
            startActivity(Intent)
        }




        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_customer_home)
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
                R.id.home -> {
                    val Intent = Intent(this, CustomerHome::class.java)
                    startActivity(Intent)
                }
                R.id.edit_profile -> {
                    val Intent = Intent(this, Profile::class.java)
                    startActivity(Intent)
                }
                R.id.view_maid -> {
                    val Intent = Intent(this, PrivacyPolicy::class.java)
                    startActivity(Intent)
                }
                R.id.my_services -> {
                    val Intent = Intent(this, MyServices::class.java)
                    startActivity(Intent)
                }
                R.id.logout -> {
                    firebaseAuth.signOut()

                    val Intent = Intent(this, Login::class.java)
                    startActivity(Intent)
                }




            }
            true

        }

        val header = navView.getHeaderView(0)

        if (firebaseAuth.currentUser != null){
            val userImage = header.findViewById<ImageView>(R.id.imageView)
            val userName = header.findViewById<TextView>(R.id.userName)
            val userEmail = header.findViewById<TextView>(R.id.useremail)

            userName.text = firebaseAuth.currentUser!!.displayName
            userEmail.text = firebaseAuth.currentUser!!.email
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.customer_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                firebaseAuth.signOut()
                val Intent = Intent(this, Login::class.java)
                startActivity(Intent)


                true
            }
            R.id.action_profile -> {
                val Intent = Intent(this, Profile::class.java)
                startActivity(Intent)


                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_customer_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    override fun onBackPressed() {

        val intent = Intent(this, First::class.java)
        startActivity(intent)
        finish()
    }
}