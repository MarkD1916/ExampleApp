package com.example.navigation

interface NavigationManager {

    fun replaceFragment(route: Routes)
    fun addFragment(route: Routes)
    fun goToAppInitialScreen()
    fun goToFeatureInitialScreen(featureInitialScreen: Routes)
    fun initFragment()

}

interface InstanceOfFragment

enum class Routes {
    MAIN_PAGE_ROUTE,
    AUTH_SCREEN
}