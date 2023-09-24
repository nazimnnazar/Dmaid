package com.example.dmaid.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dmaid.Maids
import com.example.dmaid.Repository.MaidRepository

class MaidViewModel : ViewModel() {

    private val repository : MaidRepository
    private val _allMaids = MutableLiveData<List<Maids>>()
    val allMaids : LiveData<List<Maids>> = _allMaids


    init {

        repository = MaidRepository().getInstance()
        repository.loadmaids(_allMaids)

    }
}