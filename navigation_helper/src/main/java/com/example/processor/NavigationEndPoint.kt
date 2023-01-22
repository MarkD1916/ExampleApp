package com.example.processor

import androidx.fragment.app.Fragment
import com.example.auth_screen.AuthScreen
import com.example.main_page.MainPageFragment
import com.example.navigation.Routes

object NavigationEndPoint {

    fun getFragmentByRoute(route: Routes): Fragment {
        return when(route) {
            Routes.MAIN_PAGE_ROUTE -> {
                MainPageFragment()
            }
            Routes.AUTH_SCREEN -> {
                AuthScreen()
            }
            else -> throw Exception("This fragment is absent")
        }
    }

}