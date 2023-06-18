package com.example.navigation

interface NavigationManager {

    fun replaceFragment(route: Routes)
    fun addFragment(route: Routes)
    fun addFragmentWithClearVm(route: Routes, tage: String)
    fun goToAppInitialScreen()
    fun goToFeatureInitialScreen(featureInitialScreen: Routes)
    fun initFragment()
    fun goBack()
    fun closeApp()
}

interface InstanceOfFragment

enum class Routes {
    MAIN_PAGE_ROUTE,
    AUTH_SCREEN,
    SEARCH_SCREEN,
    UNKNOWN
}