package com.example.fetch.data

import retrofit2.http.GET
import retrofit2.http.Query

interface InfoService {

    @GET("hiring.json")
    suspend fun getInfo(): List<InfoResponse>
}