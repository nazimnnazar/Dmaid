package com.example.dmaid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dmaid.Adapter.ApertmentAdapter
import com.example.dmaid.Adapter.MyAdapter
import com.google.firebase.database.*

class AdminViewApartments : AppCompatActivity() {

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var empList: ArrayList<Apartments>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_view_apartments)

        empRecyclerView = findViewById(R.id.rvEmp)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        empList = arrayListOf<Apartments>()

        getApartmentData()

    }

    private fun getApartmentData() {
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("apartments")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(Apartments::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = ApertmentAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : ApertmentAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {

                            val intent = Intent(this@AdminViewApartments, ApartmentDetails::class.java)

                            //put extras
                            intent.putExtra("apid", empList[position].apid)
                            intent.putExtra("apartmentname", empList[position].apartmentname)
                            intent.putExtra("cluster", empList[position].cluster)
                            intent.putExtra("area", empList[position].area)
                            intent.putExtra("city", empList[position].city)
                            intent.putExtra("pin", empList[position].pin)
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