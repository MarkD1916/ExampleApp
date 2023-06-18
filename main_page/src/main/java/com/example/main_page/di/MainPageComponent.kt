package com.example.main_page.di

import com.example.main_page.ui.MainPageViewModel
import dagger.Component


@Component(modules = [MainPageModule::class])
@MainPageScope
interface MainPageComponent {

    fun getMainPageViewModel(): MainPageViewModel.MainPageViewModelFactory

}