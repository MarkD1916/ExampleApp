package com.example.main_page.models

import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.Routes

sealed interface MainPageActions {

    data class Navigation(
        val title: String,
        val route: Routes
    ) : MainPageActions

}

sealed class MainPageHolders(layout: ViewGroup) : RecyclerView.ViewHolder(layout) {

    class NavigationHolder(
        layout: LinearLayout,
        val title: TextView
    ) : MainPageHolders(layout = layout)

}