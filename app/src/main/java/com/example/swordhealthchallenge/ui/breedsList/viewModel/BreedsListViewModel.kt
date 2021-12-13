package com.example.swordhealthchallenge.ui.breedsList.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.swordhealthchallenge.R
import com.example.swordhealthchallenge.network.repository.breedsListRepository.BreedsListRepository
import com.example.swordhealthchallenge.network.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class BreedsListViewModel  @Inject constructor(
    private val repository: BreedsListRepository
): ViewModel(){

    fun getBreeds(context: Context) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getBreeds(context.getString(R.string.token), context)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error occurred"))
        }
    }

}