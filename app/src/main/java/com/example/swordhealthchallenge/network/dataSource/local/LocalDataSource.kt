package com.example.swordhealthchallenge.network.dataSource.local

import com.example.swordhealthchallenge.room.BreedEntity

interface LocalDataSource {
    suspend fun setBreedsList(breedsList: List<BreedEntity>?)
    fun getBreedsList(): List<BreedEntity>

    fun deleteBreedsList(breedsList: List<BreedEntity>)
}