package com.example.swordhealthchallenge.network.dataSource.local

import com.example.swordhealthchallenge.room.BreedEntity
import com.example.swordhealthchallenge.room.DatabaseDao
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val database: DatabaseDao
): LocalDataSource {
    override suspend fun setBreedsList(breedsList: List<BreedEntity>?) = this.database.setBreedsList(breedsList)
    override fun getBreedsList(): List<BreedEntity> = this.database.getBreedsList()

    override fun deleteBreedsList(breedsList: List<BreedEntity>) = this.database.deleteBreedsList(breedsList)
}