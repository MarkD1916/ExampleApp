package com.example.core.ui

import android.animation.Animator

class AnimationListenerImpl : Animator.AnimatorListener {

    override fun onAnimationStart(animation: Animator?) {}

    override fun onAnimationCancel(animation: Animator?) {}

    override fun onAnimationRepeat(animation: Animator?) {}

    override fun onAnimationEnd(p0: Animator) {}

}