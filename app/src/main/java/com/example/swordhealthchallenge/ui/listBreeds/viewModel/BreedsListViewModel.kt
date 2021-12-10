package com.example.swordhealthchallenge.ui.listBreeds.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.swordhealthchallenge.network.repository.BreedRepository
import com.example.swordhealthchallenge.network.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class BreedsListViewModel  @Inject constructor(
    private val repository: BreedRepository
): ViewModel(){

    fun getBreeds() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getBreeds("2ae864f4-bb75-4588-8700-672169eb4ac2")))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error occurred"))
        }
    }

}