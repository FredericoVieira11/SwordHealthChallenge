package com.example.swordhealthchallenge.network.repository

import com.example.swordhealthchallenge.network.model.BreedModel

interface BreedRepository {

    suspend fun getBreeds(token: String): List<BreedModel>
}