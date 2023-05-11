package com.example.core.ui.views.navigation

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import com.example.core.R
import com.example.core.ui.views.base.AnimatedClickableView

class NavigationLayoutView : AnimatedClickableView {

    var attributeArray: TypedArray? = null

    constructor(context: Context) : super(context) {
        View.inflate(context, R.layout.navigation_layout, this)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        View.inflate(context, R.layout.navigation_layout, this)
        attributeArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.NavigationLayoutView,
            0,
            0
        )

        val title = attributeArray?.getString(R.styleable.NavigationLayoutView_nav_title)

        val navigationViewTitle = findViewById<TextView>(R.id.navigation_title)
        navigationViewTitle.text = title
    }


    fun setTitle(@StringRes title: Int) {
        val navigationViewTitle = findViewById<TextView>(R.id.navigation_title)
        navigationViewTitle.text = context.getText(title)
    }

}