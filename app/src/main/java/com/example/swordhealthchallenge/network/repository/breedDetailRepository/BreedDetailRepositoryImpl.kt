package com.example.swordhealthchallenge.network.repository.breedDetailRepository

import com.example.swordhealthchallenge.network.dataSource.remote.RemoteDataSource
import com.example.swordhealthchallenge.network.model.BreedDetailsModel
import javax.inject.Inject

class BreedDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): BreedDetailRepository {

    override suspend fun getBreedDetails(token: String, name: String): List<BreedDetailsModel>? {
        return this.remoteDataSource.getBreedDetails(
            token, name
        ).body()?.map {
            BreedDetailsModel(
                it.name,
                it.group,
                it.origin,
                it.temperament
            )
        }
    }

}