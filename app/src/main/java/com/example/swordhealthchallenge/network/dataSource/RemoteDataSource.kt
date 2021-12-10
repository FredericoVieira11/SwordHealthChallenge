package com.example.swordhealthchallenge.network.dataSource

import com.example.swordhealthchallenge.network.response.BreedResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getBreeds(token: String): Response<List<BreedResponse>>
}