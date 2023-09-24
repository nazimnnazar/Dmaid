package com.example.dmaid

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.*

class MaidDetails : AppCompatActivity() {

    private lateinit var tvFname: TextView
    private lateinit var tvLname: TextView
    private lateinit var tvUsername: TextView
    private lateinit var tvArea: TextView
    private lateinit var tvCity: TextView
    private lateinit var tvPhonenum: TextView
    private lateinit var tvPin: TextView
    private lateinit var tvPass: TextView
    private lateinit var tvCluster: TextView
    private lateinit var tvCategory: TextView
    private lateinit var tvWhatsappNum: TextView
    private lateinit var tvAlternateNum: TextView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button

    private lateinit var spincent : String
    private lateinit var dateToStr: String

    private lateinit var mid: String
    private lateinit var baseamount : String
    private lateinit var days : String
    var baseamt = 0
    var spearnings = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maid_details)

        mid = intent.getStringExtra("maidid").toString()

        initView()
        setValuesToViews()



        val today = Date()
        val outformat = SimpleDateFormat("yyyy-MM")
        dateToStr= outformat.format(today)



        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("maidid").toString(),
                intent.getStringExtra("firstname").toString()
            )
        }

        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("maidid").toString()
            )
        }
        val btnSpecialIncentive = findViewById<Button>(R.id.btn)
        btnSpecialIncentive.setOnClickListener {
            openUpdateStatusDialog(
                intent.getStringExtra("maidid").toString()

            )

            val n13 = FirebaseDatabase.getInstance().getReference("maidearnings")
            val nn13 = n13.child(dateToStr).child(mid)
            nn13.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        baseamount =
                            dataSnapshot.child("base_earnings").getValue(Long::class.java).toString()
                        days =
                            dataSnapshot.child("noofdays").getValue(Long::class.java).toString()
                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                }
            })

        }

    }

    private fun openUpdateStatusDialog(maidid: String) {
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.special_incentive, null)

        mDialog.setView(mDialogView)

        val status = mDialogView.findViewById<CheckBox>(R.id.chstatus)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)



        mDialog.setTitle("Special Incentive")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {

            val ref = FirebaseDatabase.getInstance().reference.child("maids").child(maidid)
            val updates: MutableMap<String, Any> = HashMap()

            if (status.isChecked) {
                updates["specialIncentive"] = "YES"

            }
            spincent = "YES"

            Toast.makeText(this," updated", Toast.LENGTH_SHORT).show()

//etc
            ref.updateChildren(updates)





            if (spincent == "YES")
            {
                val ref1 = FirebaseDatabase.getInstance().reference.child("maidearnings").child(dateToStr).child(maidid)
                val updates1: MutableMap<String, Any> = HashMap()


                val amt: Int = baseamount.toInt()
                val damt: Int = days.toInt() * 2
                val amount: Double = amt * 0.05
                val amount1: Double = amount * damt
                spearnings = amount1.toInt()

                updates1["special_incentive"] = spearnings

                ref1.updateChildren(updates1)
            }







//etc


            alertDialog.dismiss()
        }
    }

    private fun deleteRecord(id: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("maids").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "Maid data deleted", Toast.LENGTH_LONG).show()

            val intent = Intent(this, AdminViewMaids::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{ error ->
            Toast.makeText(this, "Deleting failed due to ${error.message}", Toast.LENGTH_LONG).show()
        }
    }




    private fun openUpdateDialog(maidid: String, firstname: String) {

        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.update_maid, null)

        mDialog.setView(mDialogView)

        val etFirstName = mDialogView.findViewById<EditText>(R.id.mfname)
        val etlastName = mDialogView.findViewById<EditText>(R.id.mlname)
        val etUsername = mDialogView.findViewById<EditText>(R.id.musername)
        val etArea = mDialogView.findViewById<EditText>(R.id.marea)
        val etCity = mDialogView.findViewById<EditText>(R.id.mcity)
        val etPhonenumber = mDialogView.findViewById<EditText>(R.id.mphnnum)
        val etPassword = mDialogView.findViewById<EditText>(R.id.mpass)
        val etCluster = mDialogView.findViewById<EditText>(R.id.mcluster)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)

        etFirstName.setText(intent.getStringExtra("firstname").toString())
        etlastName.setText(intent.getStringExtra("lastname").toString())
        etUsername.setText(intent.getStringExtra("username").toString())
        etArea.setText(intent.getStringExtra("area").toString())
        etCity.setText(intent.getStringExtra("city").toString())
        etPhonenumber.setText(intent.getStringExtra("phonenumber").toString())
        etPassword.setText(intent.getStringExtra("password").toString())
        etCluster.setText(intent.getStringExtra("cluster").toString())

        mDialog.setTitle("Updating $firstname Record")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {
            val ref1 = FirebaseDatabase.getInstance().reference.child("maids").child(mid)
            val updates1: MutableMap<String, Any> = HashMap()

            updates1["Firstname"] = etFirstName.text.toString()
            updates1["lastname"] = etlastName.text.toString()
            updates1["username"] = etUsername.text.toString()
            updates1["area"] = etArea.text.toString()
            updates1["city"] = etCity.text.toString()
            updates1["phonenumber"] = etPhonenumber.text.toString()
            updates1["password"] = etPassword.text.toString()
            updates1["cluster"] = etCluster.text.toString()

            ref1.updateChildren(updates1)

            Toast.makeText(applicationContext, "Maid Data Updated", Toast.LENGTH_LONG).show()

            //we are setting updated data to our textviews
            tvFname.text = etFirstName.text.toString()
            tvLname.text = etlastName.text.toString()
            tvUsername.text = etUsername.text.toString()
            tvArea.text = etArea.text.toString()
            tvCity.text = etCity.text.toString()
            tvPhonenum.text = etPhonenumber.text.toString()
            tvPass.text = etPassword.text.toString()
            tvCluster.text = etCluster.text.toString()





            alertDialog.dismiss()
        }
    }

    private fun setValuesToViews() {

        tvFname.text = intent.getStringExtra("firstname")
        tvLname.text = intent.getStringExtra("lastname")
        tvUsername.text = intent.getStringExtra("username")
        tvArea.text = intent.getStringExtra("area")
        tvCity.text = intent.getStringExtra("city")
        tvPhonenum.text = intent.getStringExtra("phonenumber")
        tvPin.text = intent.getStringExtra("pin")
        tvPass.text = intent.getStringExtra("password")
        tvCluster.text = intent.getStringExtra("cluster")
        tvCategory.text = intent.getStringExtra("category")
        tvWhatsappNum.text = intent.getStringExtra("whatsappnumber")
        tvAlternateNum.text = intent.getStringExtra("alternatenumber")
    }

    private fun initView() {


        tvFname = findViewById(R.id.tvfname)
        tvLname = findViewById(R.id.tvlnmae)
        tvUsername = findViewById(R.id.tvusername)
        tvArea = findViewById(R.id.tvarea)
        tvCity = findViewById(R.id.tvcity)
        tvPhonenum = findViewById(R.id.tvphonenum)
        tvPin = findViewById(R.id.tvpin)
        tvPass = findViewById(R.id.tvpass)
        tvCategory = findViewById(R.id.tvcategory)
        tvCluster = findViewById(R.id.tvclust)
        tvAlternateNum = findViewById(R.id.tvalternatenm)
        tvWhatsappNum = findViewById(R.id.tvwhatsappNum)



        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }
}