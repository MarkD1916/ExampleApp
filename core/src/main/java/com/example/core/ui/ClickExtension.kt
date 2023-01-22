package com.example.core.ui

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View

enum class ScaleDirectionType {
    UP, DOWN
}

@SuppressLint("ClickableViewAccessibility")
fun AnimatedClickableView.onClickWithScaleAnimate(
    duration: Long = 50L,
    scaleType: ScaleDirectionType = ScaleDirectionType.DOWN,
    scaleDegree: Float = 0.1f,
    onClick: () -> Unit
) {
    val start: Float
    val end: Float
    when (scaleType) {
        ScaleDirectionType.DOWN -> {
            start = 1f - scaleDegree
            end = 1f
        }
        ScaleDirectionType.UP -> {
            start = 1f + scaleDegree
            end = 1f
        }
    }

    val xScaleStart: PropertyValuesHolder = PropertyValuesHolder.ofFloat(View.SCALE_X, start)
    val yScaleStart: PropertyValuesHolder = PropertyValuesHolder.ofFloat(View.SCALE_Y, start)
    val animDown: ObjectAnimator =
        ObjectAnimator.ofPropertyValuesHolder(this, xScaleStart, yScaleStart)
    animDown.repeatCount = 0
    animDown.duration = duration


    val xScaleEnd: PropertyValuesHolder = PropertyValuesHolder.ofFloat(View.SCALE_X, end)
    val yScaleEnd: PropertyValuesHolder = PropertyValuesHolder.ofFloat(View.SCALE_Y, end)
    val animUp: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, xScaleEnd, yScaleEnd)
    animUp.repeatCount = 0
    animUp.duration = duration

    animUp.addListener(object : Animator.AnimatorListener by AnimationListenerImpl() {
        override fun onAnimationEnd(p0: Animator) = onClick()
    })

    this.setOnTouchListener { _, event ->
        when (event.action) {
            MotionEvent.ACTION_UP -> {
                animDown.cancel()
                animUp.start()
            }
            MotionEvent.ACTION_DOWN -> animDown.start()
        }
        true
    }
}