package com.example.swordhealthchallenge.network.repository.breedsListRepository

import com.example.swordhealthchallenge.network.model.BreedModel

interface BreedsListRepository {

    suspend fun getBreeds(token: String): List<BreedModel>
}