package com.example.swordhealthchallenge.network.response

import com.google.gson.annotations.SerializedName

data class BreedDetailsResponse (
    val name: String,
    @SerializedName("breed_group")
    val category: String,
    val origin: String,
    val temperament: String
)