package com.example.main_page

import androidx.fragment.app.Fragment
import com.example.core.FeatureActive

interface MainPageAction {

    fun goToAuthFeature()

}

abstract class MainPageContract : Fragment() {

    open val isFeatureActive: Boolean = FeatureActive.IS_MAIN_PAGE_FEATURE_ACTIVE
    abstract fun block(isFeatureActive: Boolean)

}