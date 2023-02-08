package com.example.buttomnavigationexample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buttomnavigationexample.data.GitResponse

class HomeViewModel : ViewModel() {

    private val _gitItem = MutableLiveData<List<GitResponse>>()
    val gitItem: LiveData<List<GitResponse>> = _gitItem
}