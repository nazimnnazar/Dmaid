package com.example.dmaid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dmaid.Adapter.CustomerAdapter
import com.example.dmaid.Models.Users
import com.google.firebase.database.*

class AdminViewCustomers : AppCompatActivity() {

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var empList: ArrayList<Users>
    private lateinit var dbRef: DatabaseReference
    private lateinit var ddbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_view_customers)


        empRecyclerView = findViewById(R.id.rvEmp)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        empList = arrayListOf<Users>()

        getUsersData()
    }

    private fun getUsersData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("users")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(Users::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = CustomerAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : CustomerAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {

                            val intent = Intent(this@AdminViewCustomers, CustomerDetails::class.java)

                            //put extras
                            intent.putExtra("uid", empList[position].uid)
                            intent.putExtra("firstname", empList[position].firstname)
                            intent.putExtra("lastname", empList[position].lastname)
                            intent.putExtra("address", empList[position].address)
                            intent.putExtra("pin", empList[position].pin)
                            intent.putExtra("apartment", empList[position].apartment)
                            intent.putExtra("email", empList[position].email)
                            intent.putExtra("profileimage", empList[position].profileimage)
                            intent.putExtra("familysize", empList[position].familysize)
                            intent.putExtra("spousename", empList[position].spousename)
                            intent.putExtra("doorNo", empList[position].doorNo)
                            intent.putExtra("contactnumber", empList[position].contactnumber)
                            intent.putExtra("whatsappnumber", empList[position].whatsappnumber)
                            startActivity(intent)
                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}