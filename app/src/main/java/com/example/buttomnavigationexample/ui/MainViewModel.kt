package com.example.buttomnavigationexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.buttomnavigationexample.datasource.GitServiceApi
import com.example.buttomnavigationexample.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiService: GitServiceApi): ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        MainRepository(apiService)
    }.flow.cachedIn(viewModelScope)
}