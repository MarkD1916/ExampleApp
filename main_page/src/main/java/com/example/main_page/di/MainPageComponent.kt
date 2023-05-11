package com.example.main_page.di

import com.example.main_page.ui.MainPageViewModel
import dagger.Component


@Component
@MainPageScope
interface MainPageComponent {

    fun getMainPageViewModel(): MainPageViewModel

}