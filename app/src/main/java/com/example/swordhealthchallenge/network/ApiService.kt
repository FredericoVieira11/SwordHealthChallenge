package com.example.swordhealthchallenge.network

import com.example.swordhealthchallenge.network.response.BreedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("v1/breeds")
    suspend fun getBreeds(
        @Header("x-api-key") token: String
    ): Response<List<BreedResponse>>

    @GET("v1/breeds/search")
    suspend fun getBreedDetails(
        @Header("x-api-key") token: String,
        @Query("name") name: String
    ): Response<List<BreedResponse>>

}