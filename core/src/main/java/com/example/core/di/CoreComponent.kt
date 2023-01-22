package com.example.core.di

import android.app.Application
import android.content.Context
import com.example.core.DictionaryDatabase
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [CoreModule::class,AppModule::class])
@Singleton
interface CoreComponent {
    fun context(): Context
    fun applicationContext(): Application
    fun getRetrofit(): Retrofit
    fun getDb(): DictionaryDatabase
}