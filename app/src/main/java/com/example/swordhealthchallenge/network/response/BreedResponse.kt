package com.example.swordhealthchallenge.network.response

import com.google.gson.annotations.SerializedName

data class BreedResponse (
    val id: Int,
    val name: String,
    @SerializedName("breed_group")
    val group: String,
    val origin: String,
    val temperament: String,
    val image: ImageResponse
)