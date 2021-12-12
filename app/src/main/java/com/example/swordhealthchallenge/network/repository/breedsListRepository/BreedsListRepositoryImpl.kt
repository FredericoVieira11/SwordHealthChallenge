package com.example.swordhealthchallenge.network.repository.breedsListRepository

import com.example.swordhealthchallenge.network.dataSource.RemoteDataSource
import com.example.swordhealthchallenge.network.model.BreedModel
import com.example.swordhealthchallenge.network.model.ImageModel
import javax.inject.Inject

class BreedsListRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): BreedsListRepository {

    override suspend fun getBreeds(token: String): List<BreedModel> {
        val list = this.remoteDataSource.getBreeds(token)

        return list.body()?.map {
            BreedModel(
                it.id,
                it.name,
                ImageModel(
                    it.image.url
                )
            )
        }?.sortedBy { it.name }!!
    }

}