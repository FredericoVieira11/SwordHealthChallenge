package com.example.swordhealthchallenge.network.response

data class BreedResponse (
    val id: Int,
    val name: String,
    val origin: String,
    val temperament: String,
    val image: ImageResponse
)