package com.example.dmaid

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.dmaid.Activity.Customer.PrivacyPolicy
import com.example.dmaid.Activity.Customer.Profile
import com.example.dmaid.Activity.Home
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FragmentDaily : Fragment() {




    private lateinit var firebaseauth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_daily, container, false)

        var btn = v.findViewById<View>(R.id.editp) as TextView
        btn.setOnClickListener {
            var intent = Intent(this@FragmentDaily.requireContext(), Profile::class.java)
            startActivity(intent)
        }

        var privacy = v.findViewById<View>(R.id.privacy) as TextView
        privacy.setOnClickListener {
            var intent = Intent(this@FragmentDaily.requireContext(), PrivacyPolicy::class.java)
            startActivity(intent)
        }

        var close = v.findViewById<View>(R.id.close) as ImageView
        close.setOnClickListener {
            var intent = Intent(this@FragmentDaily.requireContext(), Home::class.java)
            startActivity(intent)
        }
        var profilepic = v.findViewById<View>(R.id.profile) as ImageView
        var username = v.findViewById<View>(R.id.textView9) as TextView
        var addresss = v.findViewById<View>(R.id.textView11) as TextView




        firebaseauth = FirebaseAuth.getInstance()

            val ref = FirebaseDatabase.getInstance().getReference("users")
            ref.child(firebaseauth.uid!!)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val firstname = "${snapshot.child("firstname").value}"
                        val address = "${snapshot.child("address").value}"

                        username.text = firstname
                        addresss.text = address
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })





        return v
    }


}