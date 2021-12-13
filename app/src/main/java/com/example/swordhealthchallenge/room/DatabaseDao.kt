package com.example.swordhealthchallenge.room

import androidx.room.*

@Dao
interface DatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setBreedsList(breedsList: List<BreedEntity>?)

    @Query("SELECT * FROM breed ")
    fun getBreedsList(): List<BreedEntity>

    @Delete
    fun deleteBreedsList(breedsList: List<BreedEntity>)
}