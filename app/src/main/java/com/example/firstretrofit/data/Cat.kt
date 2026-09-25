package com.example.firstretrofit.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    @SerialName("id")
    val id: String="",
    @SerialName("mimetype")
    val mimetype: String="",
    @SerialName("createdAt")
    val createdAt: String="",
    @SerialName("tags")
    var tags: List<String>
)
