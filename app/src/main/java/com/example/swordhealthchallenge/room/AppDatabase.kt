package com.example.swordhealthchallenge.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BreedEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun recipeDao(): DatabaseDao
}