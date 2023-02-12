package com.example.buttomnavigationexample.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.buttomnavigationexample.data.GitResponseItem
import com.example.buttomnavigationexample.datasource.GitServiceApi
import javax.inject.Inject

class MainDataSource @Inject constructor(val apiService : GitServiceApi)
    : PagingSource<Int, GitResponseItem>() {

    var _liveDataresonse = MutableLiveData<List<GitResponseItem>>()
    var liveDataresonse = _liveDataresonse

    override fun getRefreshKey(state: PagingState<Int, GitResponseItem>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GitResponseItem> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getGitPages(currentPage)
            val responseData = mutableListOf<GitResponseItem>()
            val data = response.body() ?: emptyList()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


}