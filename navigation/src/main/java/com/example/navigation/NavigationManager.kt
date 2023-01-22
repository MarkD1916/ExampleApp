package com.example.navigation

interface NavigationManager {

    fun goTo(route: Routes)

    fun initFragment()

}

enum class Routes {
    MAIN_PAGE_ROUTE,
    AUTH_SCREEN
}