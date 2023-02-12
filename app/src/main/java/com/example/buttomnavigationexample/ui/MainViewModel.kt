package com.example.buttomnavigationexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.buttomnavigationexample.data.GitResponseItem
import com.example.buttomnavigationexample.datasource.GitServiceApi
import com.example.buttomnavigationexample.repository.MainDataSource
import com.example.buttomnavigationexample.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel(){

   /* val listData = Pager(PagingConfig(pageSize = 20)) {
        MainDataSource(apiService)
    }.liveData*/

    val liveData = mainRepository.getGitData().cachedIn(viewModelScope)

    var listRepoData : List<GitResponseItem>? = null
    get() = field
    set(value)  {field = value}
}