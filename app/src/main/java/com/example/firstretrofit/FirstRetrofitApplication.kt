package com.example.firstretrofit

import android.app.Application
import com.example.firstretrofit.di.appModules
import org.koin.core.context.startKoin

class FirstRetrofitApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(appModules)
        }
    }
}