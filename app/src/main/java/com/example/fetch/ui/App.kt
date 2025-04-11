package com.example.fetch

import android.app.Application
import com.example.fetch.data.dataModule
import com.example.fetch.domain.domainModule
import com.example.fetch.presentation.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }

    companion object {

        val appModules = mutableListOf(
            dataModule,
            domainModule,
            presentationModule
        )
    }
}