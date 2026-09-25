package com.example.firstretrofit.di

import com.example.firstretrofit.data.PetsRepository
import com.example.firstretrofit.data.PetsRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import retrofit2.Retrofit

val appModules= module {
    single<PetsRepository> { PetsRepositoryImpl(get(),get()) }
    single { Dispatchers.IO }
    single {
        Retrofit.Builder().baseUrl("https://cataas.com/api/").
                addConverterFactory(GsonConverterFactory)
    }
}