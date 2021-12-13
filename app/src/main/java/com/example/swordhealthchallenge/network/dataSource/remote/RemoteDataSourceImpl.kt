package com.example.swordhealthchallenge.network.dataSource.remote

import com.example.swordhealthchallenge.network.ApiService
import com.example.swordhealthchallenge.network.response.BreedDetailsResponse
import com.example.swordhealthchallenge.network.response.BreedResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): RemoteDataSource {

    override suspend fun getBreeds(
        token: String
    ): Response<List<BreedResponse>> = this.apiService.getBreeds(token = token)

    override suspend fun getBreedDetails(
        token: String,
        name: String
    ): Response<List<BreedDetailsResponse>> = this.apiService.getBreedDetails(token = token, name = name)
}