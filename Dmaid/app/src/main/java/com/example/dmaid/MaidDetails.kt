package com.example.dmaid

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dmaid.Activity.AdminHome
import com.example.dmaid.Activity.maid.Menupage
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.squareup.picasso.Picasso
import java.io.ByteArrayOutputStream
import java.io.IOException
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
    private lateinit var etProfImg: ImageView

    private lateinit var spincent : String
    private lateinit var dateToStr: String

    private lateinit var mid: String
    private  var baseamount : String =""
    private  var days : String=""
    var baseamt = 0
    var spearnings = 0.00

    private var filePath: Uri? = null
    private lateinit var storageReference: StorageReference

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
                        baseamount=dataSnapshot.child("Base_earning").getValue(Long::class.java).toString()
                    }
                    if (dataSnapshot.exists()) {
                        days=dataSnapshot.child("noofdays").getValue(Long::class.java).toString()
                    }

                }
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w(ContentValues.TAG, "onCancelled", databaseError.toException())
                   // Toast.makeText(MaidDetails.this, "onCancelled", Toast.LENGTH_LENGTH_LONG).show()

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


            if (!baseamount.equals("")) {
                if (!days.equals("")) {
                    if (spincent == "YES") {
                        val ref1 =
                            FirebaseDatabase.getInstance().reference.child("maidearnings")
                                .child(dateToStr)
                                .child(maidid)
                        val updates1: MutableMap<String, Any> = HashMap()


                        val amt: Int = baseamount.toInt()
                        val damt: Int = days.toInt() * 2
                        val amount: Double = amt * 0.05
                        val amount1: Double = amount * damt
                        spearnings = amount1

                        updates1["special_incentive"] = spearnings
                        ref.updateChildren(updates)

                        ref1.updateChildren(updates1)
                        Toast.makeText(this," updated", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this@MaidDetails,"Maid haven't completed any work yet",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@MaidDetails,"Maid haven't completed any work yet",Toast.LENGTH_SHORT).show()
            }


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

        etProfImg = mDialogView.findViewById<ImageView>(R.id.tvpimg1)
        val ref = FirebaseDatabase.getInstance().getReference("maids").child(maidid).child("profileImage")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val imageUrl = dataSnapshot.getValue(String::class.java).toString()
                    if (!imageUrl.equals("")){
                    Picasso.get().load(imageUrl).fit().centerCrop().into(etProfImg)
                    }else{
                        try{
                            Glide.with(this@MaidDetails)
                                .load(etProfImg)
                                .placeholder(R.drawable.ic_person_grey).into(etProfImg)
                        }
                        catch (e: Exception){
                            e.printStackTrace()
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle the error
            }
        })


        val etFirstName = mDialogView.findViewById<EditText>(R.id.mfname)
        val etlastName = mDialogView.findViewById<EditText>(R.id.mlname)
        val etUsername = mDialogView.findViewById<EditText>(R.id.musername)
        val etArea = mDialogView.findViewById<EditText>(R.id.marea)
        val etCity = mDialogView.findViewById<EditText>(R.id.mcity)
        val etPhonenumber = mDialogView.findViewById<EditText>(R.id.mphnnum)
        val etPassword = mDialogView.findViewById<EditText>(R.id.mpass)
        val etCluster = mDialogView.findViewById<EditText>(R.id.mcluster)
        val profileImage = etProfImg.toString()

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)



        etFirstName.setText(intent.getStringExtra("firstname").toString())
        etlastName.setText(intent.getStringExtra("lastname").toString())
        etUsername.setText(intent.getStringExtra("username").toString())
        etArea.setText(intent.getStringExtra("area").toString())
        etCity.setText(intent.getStringExtra("city").toString())
        etPhonenumber.setText(intent.getStringExtra("phonenumber").toString())
        etPassword.setText(intent.getStringExtra("password").toString())
        etCluster.setText(intent.getStringExtra("cluster").toString())
        /* etProfImg.setImageResource(intent.getStringExtra("Profile Image").toString())*/

        if (profileImage.isEmpty()) {
            etProfImg.setImageResource(
                R.drawable.ic_person_grey
            )
        } else {

            val filepath6 =
                "maid/$maidid/profileimg"
            storageReference =
                FirebaseStorage.getInstance()
                    .getReference(
                        filepath6
                    )
            filePath?.let { it1 ->
                storageReference.putFile(
                    it1
                )
                    .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->
                        Log.e(
                            this.localClassName,
                            "image upload success..."
                        )


                        /*  progressDialog.dismiss()*/

                    }
                    .addOnFailureListener {
                        Log.e(
                            this.localClassName,
                            "image upload failed..."
                        )
                    }
            }
        }


        mDialog.setTitle("Updating $firstname Record")

        val alertDialog = mDialog.create()
        alertDialog.show()

        etProfImg.setOnClickListener {
            selectImage()
        }


        btnUpdateData.setOnClickListener {
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

                filePath?.let { filePath ->
                    val storageRef: StorageReference = FirebaseStorage.getInstance()
                        .getReference("maids/$maidid/profileimg")
                    storageRef.putFile(filePath)
                        .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->
                            // Get the download URL of the uploaded image
                            storageRef.downloadUrl.addOnSuccessListener { uri ->
                                val downloadUrl = uri.toString()

                                // Save the download URL to Firebase Realtime Database
                                updates1["profileImage"] = downloadUrl

                                ref1.updateChildren(updates1)
                                    .addOnSuccessListener {
                                        Toast.makeText(
                                            applicationContext,
                                            "Maid Data Updated",
                                            Toast.LENGTH_LONG
                                        ).show()

                                        // Update the ImageView with the uploaded image
                                        etProfImg.setImageURI(filePath)

                                        alertDialog.dismiss()
                                    }
                                    .addOnFailureListener { exception ->
                                        Toast.makeText(
                                            applicationContext,
                                            "Failed to update Maid Data: ${exception.message}",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                            }
                        }
                        .addOnFailureListener { exception ->
                            Toast.makeText(
                                applicationContext,
                                "Failed to upload image: ${exception.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                }



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
                val profileimage = "maids/$mid/profileimage"

                try {
                    Glide.with(this)
                        .load(profileimage)
                        .placeholder(R.drawable.ic_person_grey).into(etProfImg)
                } catch (e: Exception) {

                }


                alertDialog.dismiss()

            }
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

        private fun selectImage() {
            // Creating AlertDialog
            val choice =
                arrayOf<CharSequence>("Take Photo", "Choose from Gallery", "Cancel", "Delete")
            val myAlertDialog: android.app.AlertDialog.Builder =
                android.app.AlertDialog.Builder(this)
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
                    choice[item] == "Delete" -> {
                        deleteImageFromStorage()
                    }

                }
            })
            myAlertDialog.show()
        }

        private fun deleteImageFromStorage() {

            val storageRef = FirebaseStorage.getInstance().reference


            val imagePath = "maid/$mid/profileimg"
            val imageRef = storageRef.child(imagePath)

            imageRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(this, "Profile Image Deleted ", Toast.LENGTH_SHORT).show()
                }

                .addOnFailureListener { exception ->
                    Toast.makeText(this, "Cannot Del Image ", Toast.LENGTH_SHORT).show()
                }

        }

/*
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            // For loading Image

            when (requestCode) {
                0 -> if (resultCode == AppCompatActivity.RESULT_OK && data != null) {
                    val imageSelected = data.extras!!["data"] as Bitmap?
                    etProfImg.setImageBitmap(imageSelected)


                }
            }

            if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                if (data == null || data.data == null) {
                    return
                }

                filePath = data.data
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                    etProfImg.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

        }


*/

// ...

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            0 -> if (resultCode == AppCompatActivity.RESULT_OK && data != null) {
                val imageSelected = data.extras?.get("data") as Bitmap?
                if (imageSelected != null) {
                    try {
                        val stream = ByteArrayOutputStream()
                        imageSelected.compress(Bitmap.CompressFormat.JPEG, 100, stream)
                        filePath = getImageUri(this, imageSelected)

                        Glide.with(this)
                            .load(filePath)
                            .apply(RequestOptions.circleCropTransform())
                            .into(etProfImg)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            1 -> if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                if (data == null || data.data == null) {
                    return
                }

                filePath = data.data
                try {
                    Glide.with(this)
                        .load(filePath)
                        .apply(RequestOptions.circleCropTransform())
                        .into(etProfImg)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun getImageUri(context: Context, bitmap: Bitmap): Uri {
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val
                path = MediaStore.Images.Media.insertImage(context.contentResolver, bitmap, "Title", null)
        return Uri.parse(path)
    }


    override fun onBackPressed() {
            super.onBackPressed()
            val intent = Intent(this, AdminHome::class.java)
            startActivity(intent)
            finish()
        }

}
