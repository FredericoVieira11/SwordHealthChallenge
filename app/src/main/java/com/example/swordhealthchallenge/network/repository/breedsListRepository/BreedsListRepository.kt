package com.example.swordhealthchallenge.network.repository.breedsListRepository

import android.content.Context
import com.example.swordhealthchallenge.network.model.BreedModel

interface BreedsListRepository {

    suspend fun getBreeds(token: String, context: Context): List<BreedModel>
}