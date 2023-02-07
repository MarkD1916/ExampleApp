package com.example.custompagingwithsomedatasource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.processor.NavigationEndPoint
import com.example.navigation.NavigationManager
import com.example.navigation.Routes
import com.example.navigation.Routes.MAIN_PAGE_ROUTE

class MainActivity : AppCompatActivity(), NavigationManager {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) initFragment()
    }

    override fun replaceFragment(route: Routes) {
        val fragment = NavigationEndPoint.getFragmentByRoute(route)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_main_activity, fragment)
            .commit()
    }

    override fun initFragment() {
        val fragment = NavigationEndPoint.getFragmentByRoute(MAIN_PAGE_ROUTE)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_main_activity, fragment)
            .commit()
    }

    override fun addFragment(route: Routes) {
        val fragment = NavigationEndPoint.getFragmentByRoute(route)
        supportFragmentManager
            .beginTransaction()
            .addToBackStack("tag")
            .replace(R.id.fragment_container_main_activity, fragment)
            .commit()

    }

    override fun goToAppInitialScreen() {
        val fragment = NavigationEndPoint.getFragmentByRoute(MAIN_PAGE_ROUTE)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_main_activity, fragment)
            .commit()
    }

    override fun goToFeatureInitialScreen(featureInitialScreen: Routes) {
        val fragment = NavigationEndPoint.getFragmentByRoute(featureInitialScreen)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_main_activity, fragment)
            .commit()
    }
}