package com.example.navigation

import androidx.fragment.app.Fragment

interface NavigationManager {

    fun goTo(route: Routes)

    fun initFragment()

}

interface InstanceOfFragment

enum class Routes {
    MAIN_PAGE_ROUTE,
    AUTH_SCREEN
}