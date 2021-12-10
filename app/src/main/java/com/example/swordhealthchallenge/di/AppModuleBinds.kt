package com.example.swordhealthchallenge.di

import com.example.swordhealthchallenge.network.dataSource.RemoteDataSource
import com.example.swordhealthchallenge.network.dataSource.RemoteDataSourceImpl
import com.example.swordhealthchallenge.network.repository.BreedRepository
import com.example.swordhealthchallenge.network.repository.BreedRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    abstract fun bindBreedRepository(repositoryImpl: BreedRepositoryImpl): BreedRepository

}