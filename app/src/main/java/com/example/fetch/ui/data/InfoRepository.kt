package com.example.fetch.data

class InfoRepository(
    val service: InfoService
) {

    suspend fun getInfo(): List<InfoResponse> {
        return service.getInfo()
    }
}