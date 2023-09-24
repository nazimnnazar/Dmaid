package com.example.dmaid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dmaid.Adapter.MyAdapter
import com.google.firebase.database.*

class AdminViewMaids : AppCompatActivity() {

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var empList: ArrayList<Maids>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_view_maids)

        empRecyclerView = findViewById(R.id.rvEmp)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        empList = arrayListOf<Maids>()

        getEmployeesData()

    }

    private fun getEmployeesData() {


        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("maids")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(Maids::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = MyAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {

                            val intent = Intent(this@AdminViewMaids, MaidDetails::class.java)

                            //put extras
                            intent.putExtra("maidid", empList[position].maidid)
                            intent.putExtra("firstname", empList[position].firstname)
                            intent.putExtra("lastname", empList[position].lastname)
                            intent.putExtra("username", empList[position].username)
                            intent.putExtra("area", empList[position].area)
                            intent.putExtra("city", empList[position].city)
                            intent.putExtra("phonenumber", empList[position].phonenumber)
                            intent.putExtra("cluster", empList[position].cluster)
                            intent.putExtra("category", empList[position].category)
                            intent.putExtra("whatsappnumber", empList[position].whatsappnumber)
                            intent.putExtra("alternatenumber", empList[position].alternatenumber)
                            intent.putExtra("pin", empList[position].pin)
                            intent.putExtra("password", empList[position].password)
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


