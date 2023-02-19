package com.example.auth_screen

import androidx.fragment.app.Fragment
import com.example.auth_screen.di.AuthComponentProvider
import com.example.core.FeatureActive

interface AuthPageAction {

    fun goBack()

}

abstract class AuthPageContract : Fragment() {

    open val isFeatureActive: Boolean = FeatureActive.IS_AUTH_PAGE_FEATURE_ACTIVE

    abstract fun block(isFeatureActive: Boolean)

    abstract fun observeBlockingEvent()

}