package com.example.swordhealthchallenge.di

import android.content.Context
import androidx.room.Room
import com.example.swordhealthchallenge.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideMyDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "my_db"
    ).build()

    @Singleton
    @Provides
    fun provideMyDao(db: AppDatabase) = db.recipeDao()
}