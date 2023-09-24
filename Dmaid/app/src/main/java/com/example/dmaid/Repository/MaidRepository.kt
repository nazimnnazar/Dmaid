package com.example.dmaid.Repository

import androidx.lifecycle.MutableLiveData
import com.example.dmaid.Maids
import com.google.firebase.database.*

class MaidRepository {


    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("maids")

    @Volatile private var INSTANCE : MaidRepository ?= null

    fun getInstance() : MaidRepository{
        return INSTANCE ?: synchronized(this){

            val instance = MaidRepository()
            INSTANCE = instance
            instance
        }


    }


    fun loadmaids(maidLists : MutableLiveData<List<Maids>>){

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                try {

                    val maidList : List<Maids> = snapshot.children.map { dataSnapshot ->

                        dataSnapshot.getValue(Maids::class.java)!!

                    }

                    maidLists.postValue(maidList)

                }catch (e : Exception){


                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })


    }
}