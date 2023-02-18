package com.example.core

import androidx.fragment.app.Fragment
import com.example.navigation.NavigationManager

fun Fragment.navigationManager(): NavigationManager = requireActivity() as NavigationManager