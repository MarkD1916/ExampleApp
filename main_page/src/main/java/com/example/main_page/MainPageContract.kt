package com.example.main_page

import androidx.fragment.app.Fragment

interface MainPageAction {


    fun goToAuthFeature()

}

abstract class MainPageContract : Fragment() {

    val isFeatureActive: Boolean = true

}