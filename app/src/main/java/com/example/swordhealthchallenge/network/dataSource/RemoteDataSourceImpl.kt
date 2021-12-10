package com.example.swordhealthchallenge.network.dataSource

import com.example.swordhealthchallenge.network.ApiService
import com.example.swordhealthchallenge.network.response.BreedResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): RemoteDataSource {

    override suspend fun getBreeds(
        token: String
    ): Response<List<BreedResponse>> = this.apiService.getBreeds(token = token)
}