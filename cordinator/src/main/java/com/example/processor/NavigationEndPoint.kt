package com.example.processor

import androidx.fragment.app.Fragment
import com.example.auth_screen.ui.AuthScreenInterface
import com.example.main_page.ui.MainScreenInterface
import com.example.navigation.Routes

object NavigationEndPoint {

    fun getFragmentByRoute(route: Routes): Fragment {
        return when(route) {
            Routes.MAIN_PAGE_ROUTE -> {
                MainScreenInterface.newInstance()
            }
            Routes.AUTH_SCREEN -> {
                AuthScreenInterface.newInstance()
            }
            else -> throw Exception("This fragment is absent")
        }
    }

}