package com.example.firstretrofit.data

interface PetsRepository {
    suspend fun getPets(): NetworkResult<List<Cat>>
}