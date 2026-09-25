package com.example.firstretrofit.data


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsAPI {
    @GET("cats")
    suspend fun fetchCats(): Response<List<Cat>>
}