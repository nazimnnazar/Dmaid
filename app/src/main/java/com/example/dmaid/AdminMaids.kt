package com.example.dmaid

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import java.io.IOException


class AdminMaids : AppCompatActivity() {


    private  lateinit var mfname: EditText
    private  lateinit var mlname: EditText
    private  lateinit var mcluster: EditText
    private  lateinit var mcategory: Spinner
    private  lateinit var marea: EditText
    private  lateinit var mcity: EditText
    private  lateinit var mphonenum: EditText
    private  lateinit var mwhatsappnum: EditText
    private  lateinit var malternatenum: EditText
    private  lateinit var mpin: EditText
    private  lateinit var musername: EditText
    private lateinit var addadhar: EditText
    private lateinit var addId: EditText
    private lateinit var addAuthLetter: EditText
    private lateinit var addPoliceVer: EditText
    private lateinit var addMedicalVer: EditText
    private lateinit var addAcceptLetter: EditText

    private lateinit var selcategory: String

    private  lateinit var mpassword: EditText

    private lateinit var addmaid: Button
    private lateinit var viewmaid: Button
    private lateinit var database: FirebaseDatabase
    private lateinit var firebaseauth: FirebaseAuth

    private lateinit var maidproImag: ImageView

    private lateinit var dbRef: DatabaseReference

    private lateinit var storageReference: StorageReference

    private var adharpdf: Uri? = null
    private var idpdf: Uri? = null
    private var authletterpdf: Uri? = null
    private var policevpdf: Uri? = null
    private var medicalvpdf: Uri? = null
    private var accptlttrpdf: Uri? = null

    private var filePath: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_maids)

        database = FirebaseDatabase.getInstance()
        firebaseauth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference("maids")

        mfname = findViewById(R.id.mname)
        mlname = findViewById(R.id.mlastname)
        musername = findViewById(R.id.musername)
        marea = findViewById(R.id.marea)
        mcity = findViewById(R.id.mcity)
        mpin = findViewById(R.id.mpin)
        mphonenum = findViewById(R.id.mphonenum)
        mpassword = findViewById(R.id.mpassword)
        mcluster = findViewById(R.id.mcluster)
        mcategory = findViewById(R.id.mcategory)
        mwhatsappnum = findViewById(R.id.mwhatsappnum)
        malternatenum = findViewById(R.id.malternatenum)
        addadhar = findViewById(R.id.addadharBtn)
        addId = findViewById(R.id.addid)
        addAcceptLetter = findViewById(R.id.addaccepletter)
        addAuthLetter = findViewById(R.id.addAuthletter)
        addPoliceVer = findViewById(R.id.addpoliceverif)
        addMedicalVer = findViewById(R.id.addmedicalverif)
        maidproImag = findViewById(R.id.tvpimg)

        storageReference = FirebaseStorage.getInstance().getReference()

        addmaid = findViewById(R.id.addmaid)
        viewmaid = findViewById(R.id.viewmaid)

        val progressDialog = ProgressDialog(this@AdminMaids)
        progressDialog.setTitle("Maid data saving.....")
        progressDialog.setMessage("please wait....")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        maidproImag.setOnClickListener {
            selectImage()
        }


        addadhar.setOnClickListener {
            adharPick()
        }
        addId.setOnClickListener {
            idPick()
        }
        addAuthLetter.setOnClickListener {
            authLetterPick()
        }
        addPoliceVer.setOnClickListener {
            policeVerPick()
        }
        addMedicalVer.setOnClickListener {
            medicalVerPick()
        }
        addAcceptLetter.setOnClickListener {
            acceptLetterPick()
        }

        viewmaid.setOnClickListener {
            val Intent = Intent(this, AdminViewMaids::class.java)
            startActivity(Intent)
        }

        val size = arrayOf("1 Service/Day", "2 Services/Day", "3 Services/Day")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, size)
        mcategory.adapter = arrayAdapter
        mcategory.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selcategory = size[p2].toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        addmaid.setOnClickListener {
            val maidid = musername.text.toString()
            val firstname = mfname.text.toString()
            val lastname = mlname.text.toString()
            val username = musername.text.toString()
            val area = marea.text.toString()
            val city = mcity.text.toString()
            val phonenumber = mphonenum.text.toString()
            val cluster = mcluster.text.toString()
            val category = selcategory
            val whatsappnumber = mwhatsappnum.text.toString()
            val alternatenumber = malternatenum.text.toString()
            val pin = mpin.text.toString()
            val password = mpassword.text.toString()
            val adharProof = addadhar.text.toString()
            val idproof = addId.text.toString()
            val authorizationletter = addAuthLetter.text.toString()
            val policeverification = addPoliceVer.text.toString()
            val medicalverification = addMedicalVer.text.toString()
            val acceptenceletter = addAcceptLetter.text.toString()
            val profileImage = maidproImag.toString()
            val specialIncentive = "NO"



            if (username.isNotEmpty()) {
                if (password.isNotEmpty()) {


                    progressDialog.show()

                    if (adharProof.isEmpty()) {
                        addadhar.setText("nil")
                    } else {
                        val filepath = "maid/$maidid/adhar"
                        storageReference =
                            FirebaseStorage.getInstance()
                                .getReference(filepath)
                        adharpdf?.let { it1 ->
                            storageReference.putFile(it1)
                                .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->

                                    Log.e(
                                        this.localClassName,
                                        "pdf upload success..."
                                    )
                                    progressDialog.dismiss()


                                }.addOnFailureListener {
                                    Log.e(
                                        this.localClassName,
                                        "pdf upload failed..."
                                    )
                                }
                        }
                    }


                    if (idproof.isEmpty()) {
                        addId.setText("nil")
                    } else {
                        val filepath1 = "maid/$maidid/idproof"
                        storageReference =
                            FirebaseStorage.getInstance()
                                .getReference(filepath1)
                        idpdf?.let { it1 ->
                            storageReference.putFile(it1)
                                .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->

                                    Log.e(
                                        this.localClassName,
                                        "pdf upload success..."
                                    )

                                    progressDialog.dismiss()


                                }.addOnFailureListener {
                                    Log.e(
                                        this.localClassName,
                                        "pdf upload failed..."
                                    )
                                }
                        }
                    }
                    if (authorizationletter.isEmpty()) {
                        addAuthLetter.setText("nil")
                    } else {

                        val filepath2 =
                            "maid/$maidid/authorizationletter"
                        storageReference =
                            FirebaseStorage.getInstance()
                                .getReference(filepath2)
                        authletterpdf?.let { it1 ->
                            storageReference.putFile(it1)
                                .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->

                                    Log.e(
                                        this.localClassName,
                                        "pdf upload success..."
                                    )


                                    progressDialog.dismiss()

                                }.addOnFailureListener {
                                    Log.e(
                                        this.localClassName,
                                        "pdf upload failed..."
                                    )
                                }
                        }
                    }
                    if (policeverification.isEmpty()) {
                        addPoliceVer.setText("nil")
                    } else {

                        val filepath3 =
                            "maid/$maidid/acceptanceletter"
                        storageReference =
                            FirebaseStorage.getInstance()
                                .getReference(filepath3)
                        accptlttrpdf?.let { it1 ->
                            storageReference.putFile(it1)
                                .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->

                                    Log.e(
                                        this.localClassName,
                                        "pdf upload success..."
                                    )


                                    progressDialog.dismiss()

                                }.addOnFailureListener {
                                    Log.e(
                                        this.localClassName,
                                        "pdf upload failed..."
                                    )
                                }
                        }
                    }
                    if (medicalverification.isEmpty()) {
                        addMedicalVer.setText("nil")
                    } else {

                        val filepath4 =
                            "maid/$maidid/policeverification"
                        storageReference =
                            FirebaseStorage.getInstance()
                                .getReference(filepath4)
                        policevpdf?.let { it1 ->
                            storageReference.putFile(it1)
                                .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->

                                    Log.e(
                                        this.localClassName,
                                        "pdf upload success..."
                                    )

                                    progressDialog.dismiss()


                                }.addOnFailureListener {
                                    Log.e(
                                        this.localClassName,
                                        "pdf upload failed..."
                                    )
                                }
                        }
                    }
                    if (acceptenceletter.isEmpty()) {
                        addAcceptLetter.setText("nil")
                    } else {

                        val filepath5 =
                            "maid/$maidid/medicalverification"
                        storageReference =
                            FirebaseStorage.getInstance()
                                .getReference(filepath5)
                        medicalvpdf?.let { it1 ->
                            storageReference.putFile(it1)
                                .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->


                                    Log.e(
                                        this.localClassName,
                                        "pdf upload success..."
                                    )


                                    progressDialog.dismiss()

                                }.addOnFailureListener {
                                    Log.e(
                                        this.localClassName,
                                        "pdf upload failed..."
                                    )
                                }
                        }
                    }
                    if (profileImage.isEmpty()) {
                        maidproImag.setImageResource(
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


                                    progressDialog.dismiss()

                                }
                                .addOnFailureListener {
                                    Log.e(
                                        this.localClassName,
                                        "image upload failed..."
                                    )
                                }
                        }
                    }


                    val maid = Maids(
                        maidid,
                        firstname,
                        lastname,
                        username,
                        area,
                        city,
                        phonenumber,
                        cluster,
                        category,
                        whatsappnumber,
                        alternatenumber,
                        pin,
                        adharProof,
                        idproof,
                        authorizationletter,
                        policeverification,
                        medicalverification,
                        acceptenceletter,
                        profileImage,
                        password,
                        specialIncentive
                    )

                    dbRef.child(maidid)
                        .setValue(maid)
                        .addOnCompleteListener {
                            Toast.makeText(
                                this,
                                "Maid added successfully",
                                Toast.LENGTH_LONG
                            ).show()
                            progressDialog.dismiss()

                            mfname.text.clear()
                            mlname.text.clear()
                            musername.text.clear()
                            marea.text.clear()
                            mcity.text.clear()
                            mphonenum.text.clear()
                            mpin.text.clear()
                            mpassword.text.clear()
                            mcluster.text.clear()
                            malternatenum.text.clear()
                            mwhatsappnum.text.clear()
                            addadhar.text.clear()
                            addId.text.clear()
                            addPoliceVer.text.clear()
                            addMedicalVer.text.clear()
                            addAuthLetter.text.clear()
                            addAcceptLetter.text.clear()
                            maidproImag.setImageResource(
                                R.drawable.ic_person_grey
                            )

                        }
                        .addOnFailureListener { err ->
                            Toast.makeText(
                                this,
                                "Error ${err.message}",
                                Toast.LENGTH_LONG
                            )
                                .show()

                        }
                } else {
                    mpassword.error = "Please enter password"
                }
            } else {
                    musername.error = "Please enter the username "
                }

    }



}

    private fun selectImage() {
        // Creating AlertDialog
        val choice = arrayOf<CharSequence>("Take Photo", "Choose from Gallery", "Cancel")
        val myAlertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
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

            }
        })
        myAlertDialog.show()
    }

    private fun acceptLetterPick() {
        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
        pdfIntent.type = "application/pdf"
        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(pdfIntent, 8)
    }

    private fun medicalVerPick() {
        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
        pdfIntent.type = "application/pdf"
        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(pdfIntent, 11)
    }

    private fun policeVerPick() {
        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
        pdfIntent.type = "application/pdf"
        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(pdfIntent, 101)
    }

    private fun authLetterPick() {
        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
        pdfIntent.type = "application/pdf"
        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(pdfIntent, 111)
    }

    private fun idPick() {
        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
        pdfIntent.type = "application/pdf"
        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(pdfIntent, 10)
    }

    private fun adharPick() {

        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
        pdfIntent.type = "application/pdf"
        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(pdfIntent, 12)
    }
    @SuppressLint("Range")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // For loading Image

            when (requestCode) {
                0 -> if (resultCode == RESULT_OK && data != null) {
                    val imageSelected = data.extras!!["data"] as Bitmap?
                    maidproImag.setImageBitmap(imageSelected)
                }
            }

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if(data == null || data.data == null){
                return
            }

            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                maidproImag.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }




        // For loading PDF
        when (requestCode) {
            12 -> if (resultCode == RESULT_OK) {

                adharpdf = data?.data!!
                val uri: Uri = data?.data!!
                val uriString: String = uri.toString()
                var pdfName: String? = null
                if (uriString.startsWith("content://")) {
                    var myCursor: Cursor? = null
                    try {
                        myCursor = applicationContext!!.contentResolver.query(uri, null, null, null, null)
                        if (myCursor != null && myCursor.moveToFirst()) {
                            pdfName = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                            addadhar.setText(pdfName.toString())
                        }
                    } finally {
                        myCursor?.close()
                    }
                }
            }
        }


        // For loading ID PDF
        when (requestCode) {
            10 -> if (resultCode == RESULT_OK) {

                idpdf = data?.data!!
                val uri: Uri = data?.data!!
                val uriString: String = uri.toString()
                var pdfName: String? = null
                if (uriString.startsWith("content://")) {
                    var myCursor: Cursor? = null
                    try {
                        myCursor = applicationContext!!.contentResolver.query(uri, null, null, null, null)
                        if (myCursor != null && myCursor.moveToFirst()) {
                            pdfName = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                            addId.setText(pdfName.toString())
                        }
                    } finally {
                        myCursor?.close()
                    }
                }
            }
        }



        // For loading Acceptence Letter PDF
        when (requestCode) {
            8 -> if (resultCode == RESULT_OK) {

                accptlttrpdf = data?.data!!
                val uri: Uri = data?.data!!
                val uriString: String = uri.toString()
                var pdfName: String? = null
                if (uriString.startsWith("content://")) {
                    var myCursor: Cursor? = null
                    try {
                        myCursor = applicationContext!!.contentResolver.query(uri, null, null, null, null)
                        if (myCursor != null && myCursor.moveToFirst()) {
                            pdfName = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                            addAcceptLetter.setText(pdfName.toString())
                        }
                    } finally {
                        myCursor?.close()
                    }
                }
            }
        }



        // For loading Medical Verification PDF
        when (requestCode) {
            11 -> if (resultCode == RESULT_OK) {

                medicalvpdf = data?.data!!
                val uri: Uri = data?.data!!
                val uriString: String = uri.toString()
                var pdfName: String? = null
                if (uriString.startsWith("content://")) {
                    var myCursor: Cursor? = null
                    try {
                        myCursor = applicationContext!!.contentResolver.query(uri, null, null, null, null)
                        if (myCursor != null && myCursor.moveToFirst()) {
                            pdfName = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                            addMedicalVer.setText(pdfName.toString())
                        }
                    } finally {
                        myCursor?.close()
                    }
                }
            }
        }



        // For loading Police Verification PDF
        when (requestCode) {
            101 -> if (resultCode == RESULT_OK) {

                policevpdf = data?.data!!
                val uri: Uri = data?.data!!
                val uriString: String = uri.toString()
                var pdfName: String? = null
                if (uriString.startsWith("content://")) {
                    var myCursor: Cursor? = null
                    try {
                        myCursor = applicationContext!!.contentResolver.query(uri, null, null, null, null)
                        if (myCursor != null && myCursor.moveToFirst()) {
                            pdfName = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                            addPoliceVer.setText(pdfName.toString())
                        }
                    } finally {
                        myCursor?.close()
                    }
                }
            }
        }



        // For loading Authorization Letter PDF
        when (requestCode) {
            111 -> if (resultCode == RESULT_OK) {

                authletterpdf = data?.data!!
                val uri: Uri = data?.data!!
                val uriString: String = uri.toString()
                var pdfName: String? = null
                if (uriString.startsWith("content://")) {
                    var myCursor: Cursor? = null
                    try {
                        myCursor = applicationContext!!.contentResolver.query(uri, null, null, null, null)
                        if (myCursor != null && myCursor.moveToFirst()) {
                            pdfName = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                            addAuthLetter.setText(pdfName.toString())
                        }
                    } finally {
                        myCursor?.close()
                    }
                }
            }
        }
    }

}



