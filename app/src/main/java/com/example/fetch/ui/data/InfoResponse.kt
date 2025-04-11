package com.example.fetch.data

import com.squareup.moshi.Json

data class InfoResponse(
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "listId")
    val listId: Long,
    @field:Json(name = "name")
    val name: String?,
)