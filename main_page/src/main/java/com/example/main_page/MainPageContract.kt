package com.example.main_page

import androidx.annotation.StringRes
import androidx.core.view.allViews
import androidx.fragment.app.Fragment
import com.example.core.FeatureActive
import com.example.core.ui.base.BaseState
import com.example.core.ui.views.SearchTextView
import com.example.core.ui.views.navigation.NavigationLayoutView
import com.example.main_page.models.MainPageAnimationView
import com.example.navigation.Routes

interface MainPageAction {

    fun goTo(route: Routes)

}

data class MainPageState(
    var navigateToAuthScreenButton: MainPageAnimationView? = MainPageAnimationView(position = 0),
    var navigateToSearchScreenButton: MainPageAnimationView? = MainPageAnimationView(position = 1)
) : BaseState.FragmentUI

abstract class MainPageContract : Fragment() {
    val TAG = Routes.MAIN_PAGE_ROUTE.name
    open val isFeatureActive: Boolean = FeatureActive.IS_MAIN_PAGE_FEATURE_ACTIVE
    abstract fun block(isFeatureActive: Boolean)
    abstract fun initViews()
    val state = MainPageState()

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