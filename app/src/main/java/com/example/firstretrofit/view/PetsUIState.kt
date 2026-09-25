package com.example.firstretrofit.view

import com.example.firstretrofit.data.Cat

data class PetsUIState(
    val isLoading: Boolean=false,
    val pets: List<Cat> = emptyList(),
    var error: String?=null
)