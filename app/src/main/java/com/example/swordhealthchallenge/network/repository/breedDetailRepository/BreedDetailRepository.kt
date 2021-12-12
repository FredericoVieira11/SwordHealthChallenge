package com.example.swordhealthchallenge.network.repository.breedDetailRepository

import com.example.swordhealthchallenge.network.model.BreedDetailsModel

interface BreedDetailRepository {
    suspend fun getBreedDetails(token: String, name: String): List<BreedDetailsModel>?
}