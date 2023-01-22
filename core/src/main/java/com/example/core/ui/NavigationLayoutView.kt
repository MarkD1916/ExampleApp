package com.example.core.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.example.core.R

class NavigationLayoutView : AnimatedClickableView {

    constructor(context: Context) : super(context) {
        View.inflate(context, R.layout.navigation_layout, this)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        View.inflate(context, R.layout.navigation_layout, this)
    }

}