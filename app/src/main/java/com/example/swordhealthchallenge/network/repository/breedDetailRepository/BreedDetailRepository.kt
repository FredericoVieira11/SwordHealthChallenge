package com.example.swordhealthchallenge.network.repository.breedDetailRepository

import android.content.Context
import com.example.swordhealthchallenge.network.model.BreedDetailsModel

interface BreedDetailRepository {
    suspend fun getBreedDetails(token: String, name: String, context: Context): List<BreedDetailsModel>?
}