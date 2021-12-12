package com.example.swordhealthchallenge.di

import com.example.swordhealthchallenge.network.dataSource.RemoteDataSource
import com.example.swordhealthchallenge.network.dataSource.RemoteDataSourceImpl
import com.example.swordhealthchallenge.network.repository.breedsListRepository.BreedsListRepository
import com.example.swordhealthchallenge.network.repository.breedsListRepository.BreedsListRepositoryImpl
import com.example.swordhealthchallenge.network.repository.breedDetailRepository.BreedDetailRepository
import com.example.swordhealthchallenge.network.repository.breedDetailRepository.BreedDetailRepositoryImpl
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
    abstract fun bindBreedsListRepository(repositoryImpl: BreedsListRepositoryImpl): BreedsListRepository

    @Binds
    abstract fun bindBreedDetailRepository(repositoryImpl: BreedDetailRepositoryImpl): BreedDetailRepository

}