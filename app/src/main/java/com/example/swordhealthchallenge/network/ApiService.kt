package com.example.swordhealthchallenge.network

import com.example.swordhealthchallenge.network.response.BreedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("v1/breeds")
    suspend fun getBreeds(
        @Header("x-api-key") token: String
    ): Response<List<BreedResponse>>

}