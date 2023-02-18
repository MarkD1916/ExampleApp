package com.example.custompagingwithsomedatasource

import android.app.Application
import com.example.core.di.*

class Application : Application(), CoreComponentProvider {

    private lateinit var coreComponent: CoreComponent

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder()
                .appModule(AppModule(this))
                .coreModule(CoreModule())
                .build()
        }
        return coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        provideCoreComponent()
    }

}