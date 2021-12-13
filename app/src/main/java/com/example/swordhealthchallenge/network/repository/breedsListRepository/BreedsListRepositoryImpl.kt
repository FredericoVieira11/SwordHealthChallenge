package com.example.swordhealthchallenge.network.repository.breedsListRepository

import android.content.Context
import com.example.swordhealthchallenge.network.dataSource.local.LocalDataSource
import com.example.swordhealthchallenge.network.dataSource.remote.RemoteDataSource
import com.example.swordhealthchallenge.network.model.BreedModel
import com.example.swordhealthchallenge.network.model.ImageModel
import com.example.swordhealthchallenge.room.BreedEntity
import com.example.swordhealthchallenge.utils.isNetworkAvailable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BreedsListRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): BreedsListRepository {

    override suspend fun getBreeds(token: String, context: Context): List<BreedModel> {
        return if (isNetworkAvailable(context)) {
            val list = this.remoteDataSource.getBreeds(token)
            deleteData()
            saveData(token)
            list.body()?.map {
                BreedModel(
                    it.id,
                    it.name,
                    ImageModel(
                        it.image.url
                    )
                )
            }?.sortedBy { it.name }!!
        } else {
            getList()
        }
    }

    private suspend fun saveData(token: String) = withContext(Dispatchers.IO) {
        async {
            val list = remoteDataSource.getBreeds(token)
            val breedsEntityList = list.body()?.map {
                BreedEntity(
                    id = it.id,
                    name = it.name,
                    group = it.group,
                    origin = it.origin,
                    temperament = it.temperament,
                    image = it.image.url
                )
            }?.toList()
            localDataSource.setBreedsList(breedsEntityList)
        }
    }.await()

    private fun getList(): List<BreedModel> {
        val list = this.localDataSource.getBreedsList()
        return list.map {
            BreedModel(
                it.id,
                it.name,
                ImageModel(
                    it.image
                )
            )
        }.toList().sortedBy { it.name }
    }

    private fun deleteData() {
        this.localDataSource.deleteBreedsList(this.localDataSource.getBreedsList())
        this.localDataSource.getBreedsList()
    }

}