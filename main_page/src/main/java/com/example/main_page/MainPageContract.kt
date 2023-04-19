package com.example.main_page

import androidx.annotation.StringRes
import androidx.core.view.allViews
import androidx.fragment.app.Fragment
import com.example.core.FeatureActive

interface MainPageAction {

    fun goToAuthFeature()

}

abstract class MainPageContract : Fragment() {

    open val isFeatureActive: Boolean = FeatureActive.IS_MAIN_PAGE_FEATURE_ACTIVE
    abstract fun block(isFeatureActive: Boolean)
    abstract fun initViews()

    fun checkAllViewsNotNull() {
        this.view?.allViews ?: throw  Exception("some view in fragment is null")
    }

    abstract fun onError(@StringRes message: Int?)

}

fun MainPageContract.setupFeature() {
    try {
        block(isFeatureActive)
        checkAllViewsNotNull()
        initViews()
    } catch (e: Exception) {
        e.printStackTrace()
        onError(R.string.unexpected_error)
    }
}