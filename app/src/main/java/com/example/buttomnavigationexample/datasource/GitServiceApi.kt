package com.example.buttomnavigationexample.datasource

import com.example.buttomnavigationexample.data.GitResponse
import com.example.buttomnavigationexample.data.GitResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitServiceApi {
    @GET("/users")
    suspend fun getGitPages(@Query ("since") since:Int) : Response<List<GitResponseItem>>
}