package com.example.firstretrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstretrofit.data.NetworkResult
import com.example.firstretrofit.data.PetsRepository
import com.example.firstretrofit.view.PetsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PetsViewModel(private val petsRepository: PetsRepository): ViewModel() {
    val petsUiState= MutableStateFlow(PetsUIState())
    init {

    }
    private fun getPets()
    {
        petsUiState.value= PetsUIState(isLoading = true)
        viewModelScope.launch {
            when(val result=petsRepository.getPets()){
                is NetworkResult.Success->
                {
                    petsUiState.update {
                        it.copy(isLoading = false,
                            pets = result.data)
                    }
                }
                is NetworkResult.Error->
                {
                    petsUiState.update {
                        it.copy(isLoading = false,
                            error = result.error)
                    }
                }
            }
        }
    }
}