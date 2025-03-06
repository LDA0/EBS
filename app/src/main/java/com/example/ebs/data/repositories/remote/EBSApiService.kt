package com.example.ebs.data.repositories.remote

import retrofit2.http.GET

interface EBSApiService {
    @GET("books")
    suspend fun getData(): List<DataTest>
}
