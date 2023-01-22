package com.example.main_page.di

import com.example.core.di.CoreComponent
import dagger.Component


@Component(dependencies = [CoreComponent::class])
@MainPageScope
interface MainPageComponent {
}