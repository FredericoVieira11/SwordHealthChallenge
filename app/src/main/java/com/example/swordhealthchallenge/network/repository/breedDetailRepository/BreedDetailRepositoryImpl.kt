package com.example.swordhealthchallenge.network.repository.breedDetailRepository

import android.content.Context
import com.example.swordhealthchallenge.network.dataSource.local.LocalDataSource
import com.example.swordhealthchallenge.network.dataSource.remote.RemoteDataSource
import com.example.swordhealthchallenge.network.model.BreedDetailsModel
import com.example.swordhealthchallenge.utils.isNetworkAvailable
import javax.inject.Inject

class BreedDetailRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): BreedDetailRepository {

    override suspend fun getBreedDetails(token: String, name: String, context: Context): List<BreedDetailsModel>? {
        return if (isNetworkAvailable(context)) {
            this.remoteDataSource.getBreedDetails(
                token, name
            ).body()?.map {
                BreedDetailsModel(
                    it.name,
                    it.group,
                    it.origin,
                    it.temperament
                )
            }
        } else {
            getLocalBreedDetails(name)
        }
    }

    private fun getLocalBreedDetails(name: String): List<BreedDetailsModel> {
        return this.localDataSource.searchForBreed(name).map {
            BreedDetailsModel(
                it.name,
                it.group,
                it.origin,
                it.temperament,
            )
        }
    }

}