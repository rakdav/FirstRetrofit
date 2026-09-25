package com.example.firstretrofit.di

import com.example.firstretrofit.data.CatsAPI
import com.example.firstretrofit.data.PetsRepository
import com.example.firstretrofit.data.PetsRepositoryImpl
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModules= module {
    single<PetsRepository> { PetsRepositoryImpl(get(),get()) }
    single { Dispatchers.IO }
    single {
        Retrofit.Builder().baseUrl("https://cataas.com/api/").
                addConverterFactory(GsonConverterFactory.create()).
                client(OkHttpClient()).build()
    }
    single { get<Retrofit>().create(CatsAPI::class.java) }

}