package com.example.dmaid.Activity.Customer

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dmaid.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class Profile : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var fname: EditText
    private lateinit var lname: EditText
    private lateinit var adrs: EditText
    private lateinit var piN: EditText
    private lateinit var Apartment: EditText
    private lateinit var emailid: EditText
    private lateinit var profileiv: ImageView
    private  var imageuri: Uri?= null
    private lateinit var confirmBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        fname = findViewById(R.id.editTextTextPersonName)
        lname = findViewById(R.id.ed2)
        adrs = findViewById(R.id.ed3)
        piN = findViewById(R.id.ed4)
        Apartment = findViewById(R.id.ed5)
        emailid = findViewById(R.id.ed6)
        profileiv = findViewById(R.id.profileiv)
        confirmBtn = findViewById(R.id.confirmbtn)

        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()

        profileiv.setOnClickListener{
            showImageAttachMenu()
        }

        confirmBtn.setOnClickListener{
            validateData()
        }
    }
     private var firstname = ""
    private var lastname = ""
    private var doorNo = ""
    private var pin = ""
    private var email = ""
    private fun validateData() {
        firstname = fname.text.toString().trim()
        lastname = lname.text.toString().trim()
        doorNo = adrs.text.toString().trim()
        pin = piN.text.toString().trim()
        email = emailid.text.toString().trim()

        if (firstname.isEmpty())
        {
            Toast.makeText(this,"Enter your first name ",Toast.LENGTH_SHORT).show()
        }
        else if (lastname.isEmpty())
        {
            Toast.makeText(this,"Enter your last name ",Toast.LENGTH_SHORT).show()
        }
        else if (doorNo.isEmpty())
        {
            Toast.makeText(this,"Enter your address ",Toast.LENGTH_SHORT).show()
        }
        else if (pin.isEmpty())
        {
            Toast.makeText(this,"Enter your pin ",Toast.LENGTH_SHORT).show()
        }
        else if (email.isEmpty())
        {
            Toast.makeText(this,"Enter your email ",Toast.LENGTH_SHORT).show()
        }
        else
        {
            if (imageuri == null)
            {
                updateProfile("")
            }
            else
            {
                uploadImage()
            }
        }
    }

    private fun uploadImage() {
        val filePathAndName = "ProfileImages/"+firebaseAuth.uid

        val reference = FirebaseStorage.getInstance().getReference(filePathAndName)
        reference.putFile(imageuri!!)
            .addOnSuccessListener { taskSnapshot->

                val uriTask: Task<Uri> = taskSnapshot.storage.downloadUrl
                while (!uriTask.isSuccessful);
                val uploadImageUrl = "${uriTask.result}"

                updateProfile(uploadImageUrl)
            }
            .addOnFailureListener {e->
                Toast.makeText(this,"Failed to upload image due to ${e.message} ",Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateProfile(uploadImageUrl: String) {
         val hashmap: HashMap<String,Any> = HashMap()
        hashmap["firstname"] = "$firstname"
        hashmap["lastname"] = "$lastname"
        hashmap["doorNo"] = "$doorNo"
        hashmap["pin"] = "$pin"
        hashmap["email"] = "$email"

        if (imageuri != null)
        {
            hashmap["profileimage"]= uploadImageUrl
        }

        val reference = FirebaseDatabase.getInstance().getReference("users")
        reference.child(firebaseAuth.uid!!)
            .updateChildren(hashmap)
            .addOnSuccessListener {
                Toast.makeText(this,"profile updated",Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{e->
                Toast.makeText(this,"Failed to upload image due to ${e.message} ",Toast.LENGTH_SHORT).show()
            }
    }

    private fun showImageAttachMenu() {

        val popupMenu = PopupMenu(this,profileiv)
        popupMenu.menu.add(Menu.NONE,0,0,"Camera")
        popupMenu.menu.add(Menu.NONE,1,1,"Gallery")
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener { item->
            val id = item.itemId
            if (id == 0){
                pickImageCamera()
            }
            else if (id == 1){
                pickImageGallery()
            }
            true
        }
    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryActivityResultLauncher.launch(intent)
    }

    private val galleryActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> {result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data
                imageuri = data!!.data

                profileiv.setImageURI(imageuri)
            }
            else{
                Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show()
            }
        }
    )

    private val cameraActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> {result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data
                imageuri = data?.data

                profileiv.setImageURI(imageuri)
            }
            else{
                Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show()
            }
        }
    )

    private fun pickImageCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE,"Temp_Title")
        values.put(MediaStore.Images.Media.DESCRIPTION,"Temp_Description")

        imageuri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageuri)
        cameraActivityResultLauncher.launch(intent)

    }

    private fun loadUserInfo() {
        val ref = FirebaseDatabase.getInstance().getReference("users")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val firstname = "${snapshot.child("firstname").value}"
                    val lastname = "${snapshot.child("lastname").value}"
                    val doorNo = "${snapshot.child("doorNo").value}"
                    val apartment = "${snapshot.child("apartment").value}"
                    val email = "${snapshot.child("email").value}"
                    val pin = "${snapshot.child("pin").value}"
                    val profileimage = "${snapshot.child("profileimage").value}"
                    val uid = "${snapshot.child("uid").value}"

                    fname.setText(firstname)
                    lname.setText(lastname)
                    adrs.setText(doorNo)
                    piN.setText(pin)
                    Apartment.setText(apartment)
                    emailid.setText(email)

                    try{
                        Glide.with(this@Profile)
                            .load(profileimage)
                            .placeholder(R.drawable.ic_person_grey).into(profileiv)
                    }
                    catch (e: Exception){

                    }





                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }
}