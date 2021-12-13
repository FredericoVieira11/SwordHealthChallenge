package com.example.swordhealthchallenge.ui.breedDetail.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.swordhealthchallenge.R
import com.example.swordhealthchallenge.network.repository.breedDetailRepository.BreedDetailRepository
import com.example.swordhealthchallenge.network.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class BreedDetailsViewModel @Inject constructor(
    private val repository: BreedDetailRepository
): ViewModel(){

    fun getBreedDetails(context: Context, name: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getBreedDetails(context.getString(R.string.token), name, context)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error occurred"))
        }
    }

}