package com.example.dmaid

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dmaid.Activity.Customer.RateMaid
import com.example.dmaid.Activity.Home
import com.example.dmaid.databinding.ActivityCustomerViewMaidBinding
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import java.io.File

class CustomerViewMaid : AppCompatActivity() {
    private lateinit var tvname: TextView
    private lateinit var tvArea: TextView
    private lateinit var tvCity: TextView
    private lateinit var tvPin: TextView
    private lateinit var aadhar: TextView
    private lateinit var idprof: TextView
    private lateinit var medVer: TextView
    private lateinit var polVer: TextView
    private lateinit var authLetters : TextView
    private lateinit var accept: TextView

    private lateinit var idprof1 : String
    private lateinit var medVer1 : String
    private lateinit var polver1 : String
    private lateinit var authletters1 : String
    private lateinit var accept1 : String
    private lateinit var aadhar1 : String
    private lateinit var image1 : String

    private lateinit var maidProf: ImageView


    private lateinit var maidid: String
    private lateinit var binding :ActivityCustomerViewMaidBinding

    private lateinit var btnRate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_view_maid)

        tvname = findViewById(R.id.mname)
        tvArea = findViewById(R.id.marea)
        tvCity = findViewById(R.id.mcity)
        tvPin = findViewById(R.id.mpin)

        aadhar = findViewById(R.id.aadhar)
        idprof = findViewById(R.id.idprof)
        medVer = findViewById(R.id.medver)
        polVer = findViewById(R.id.polver)
        authLetters = findViewById(R.id.Authlet)
        accept  = findViewById(R.id.accept)

        btnRate = findViewById(R.id.btnRateMaid)
        maidProf = findViewById(R.id.imageView16)

        setValuesToViews()



        aadhar.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(aadhar1), "application/pdf")
            startActivity(intent)

        }
        authLetters.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(authletters1), "application/pdf")
            startActivity(intent)

        }
        accept.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(accept1), "application/pdf")
            startActivity(intent)

        }
        polVer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(polver1), "application/pdf")
            startActivity(intent)
        }
        medVer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(medVer1), "application/pdf")
            startActivity(intent)

        }
        idprof.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(idprof1), "application/pdf")
            startActivity(intent)

        }


        maidProf.setOnClickListener {
           /* val webView = findViewById<WebView>(R.id.webView)
            webView.settings.javaScriptEnabled = true
            webView.loadUrl("https://docs.google.com/gview?embedded=true&url=https://firebasestorage.googleapis.com/v0/b/dmaid-eafa6.appspot.com/o/maid%2Fandroidx.appcompat.widget.AppCompatEditText%7Bc14de92%20VFED..CL.%20......ID%2080%2C2120-1001%2C2252%20%237f09023a%20app%3Aid%2Fmusername%20aid%3D1073741833%7D%2Faadharver?alt=media&token=f8c8e4f2-1ae8-4994-b580-c291e7adc5c9")
*/
            // Alternatively, you can open the PDF file in a PDF viewer app
             val intent = Intent(Intent.ACTION_VIEW)
             intent.setDataAndType(Uri.parse("https://firebasestorage.googleapis.com/v0/b/dmaid-eafa6.appspot.com/o/maid%2Fandroidx.appcompat.widget.AppCompatEditText%7Bc14de92%20VFED..CL.%20......ID%2080%2C2120-1001%2C2252%20%237f09023a%20app%3Aid%2Fmusername%20aid%3D1073741833%7D%2Faadharver?alt=media&token=f8c8e4f2-1ae8-4994-b580-c291e7adc5c9"), "application/pdf")
             startActivity(intent)
        }

        if (tvname.text.isEmpty())
        {
            setContentView(R.layout.maid_allocation_error_page)
        }

        btnRate.setOnClickListener {
            val intent = Intent(this,RateMaid::class.java)
            intent.putExtra("maidid",maidid)
            startActivity(intent)
        }



    }

    private fun setValuesToViews() {

        tvname.text = intent.getStringExtra("firstname")
        tvArea.text = intent.getStringExtra("area")
        tvCity.text = intent.getStringExtra("city")
        tvPin.text = intent.getStringExtra("pin")
        maidid = intent.getStringExtra("maidid").toString()


        val ref = FirebaseDatabase.getInstance().getReference("maids").child(maidid)
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    image1 = dataSnapshot.child("profileImage").getValue(String::class.java).toString()
                    if (!image1.equals("")){
                        Picasso.get().load(image1).fit().centerCrop().into(maidProf)
                    }else{
                        try{
                            Glide.with(this@CustomerViewMaid)
                                .load(maidProf)
                                .placeholder(R.drawable.ic_person_grey).into(maidProf)
                        }
                        catch (e: Exception){
                            e.printStackTrace()
                        }
                    }
                    idprof1 = dataSnapshot.child("idproof").getValue(String::class.java).toString()
                    polver1 = dataSnapshot.child("policeverification").getValue(String::class.java).toString()
                    aadhar1 = dataSnapshot.child("adharProof").getValue(String::class.java).toString()
                    medVer1 = dataSnapshot.child("adharProof").getValue(String::class.java).toString()
                    accept1 = dataSnapshot.child("acceptenceletter").getValue(String::class.java).toString()
                    authletters1 = dataSnapshot.child("authorizationletter").getValue(String::class.java).toString()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle the error
            }
        })





// Create a reference to the image file
        val storageRef = FirebaseStorage.getInstance().getReference("/maid/anu/profileimg.jpg")

        val file = File.createTempFile("tempfile","jpg")
        storageRef.getFile(file).addOnSuccessListener {
            val bitmap = BitmapFactory.decodeFile(file.absolutePath)
           // binding.maidProf .setImageBitmap(bitmap)

        }

       /* Glide.with(this@CustomerViewMaid*//* Context *//*)
            .load(storageRef)
            //.apply(RequestOptions().placeholder(R.drawable.ic_person_grey)) // Optional placeholder image
            .into(maidProf)   */
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }
}


