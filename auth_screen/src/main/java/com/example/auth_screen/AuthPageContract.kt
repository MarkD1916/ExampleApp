package com.example.auth_screen

import androidx.fragment.app.Fragment
import com.example.core.FeatureActive

interface AuthPageAction {

    fun goBack()

}

abstract class AuthPageContract : Fragment() {

    val isFeatureActive: Boolean = FeatureActive.IS_AUTH_PAGE_FEATURE_ACTIVE

    abstract fun block(isFeatureActive: Boolean)

}