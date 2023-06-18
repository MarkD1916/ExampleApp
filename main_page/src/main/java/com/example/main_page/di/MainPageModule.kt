package com.example.main_page.di

import com.example.main_page.rep.MainPageRepo
import com.example.main_page.rep.MainPageRepoImpl
import dagger.Binds
import dagger.Module

@Module
interface MainPageModule {

    @Binds
    fun provideMainPageRepo(repo: MainPageRepoImpl): MainPageRepo

}