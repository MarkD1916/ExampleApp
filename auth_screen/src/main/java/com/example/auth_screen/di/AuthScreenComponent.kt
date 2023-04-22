package com.example.auth_screen.di

import com.example.auth_screen.AuthPageContract
import com.example.auth_screen.ui.AuthScreenViewModel
import com.example.core.di.CoreComponent
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [CoreComponent::class])
@AuthScreenScope
interface AuthScreenComponent {
    fun getAuthScreenViewModel() : AuthScreenViewModel

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun authScreenComponent(fragment: AuthPageContract): Builder
        fun build(): AuthScreenComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }
}