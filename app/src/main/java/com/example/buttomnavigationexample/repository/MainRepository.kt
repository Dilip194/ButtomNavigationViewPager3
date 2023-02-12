package com.example.buttomnavigationexample.repository

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.buttomnavigationexample.datasource.GitServiceApi
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class MainRepository @Inject constructor(val gitServiceApi: GitServiceApi){
    fun getGitData() = Pager(PagingConfig(pageSize = 20)) {
        MainDataSource(gitServiceApi)
    }.liveData
}