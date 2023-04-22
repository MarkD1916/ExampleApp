package com.example.core.ui.views.navigation

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import com.example.core.R
import com.example.core.ui.views.base.AnimatedClickableView

class NavigationLayoutView : AnimatedClickableView {

    constructor(context: Context) : super(context) {
        View.inflate(context, R.layout.navigation_layout, this)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        View.inflate(context, R.layout.navigation_layout, this)
    }

    fun setTitle(@StringRes title: Int) {
        val navigationViewTitle = findViewById<TextView>(R.id.navigation_title)
        navigationViewTitle.text = context.getText(title)
    }

}