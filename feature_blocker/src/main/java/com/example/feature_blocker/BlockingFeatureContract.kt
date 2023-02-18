package com.example.feature_blocker

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface BlockingAction {

    fun blockNavigationToFeature(navigationView: View)
    fun blockFeature()

}

interface RestrictionAction {

    fun showRestrictionsTopMessage()
    fun showRestrictionAlert()

}

abstract class BlockingFeatureContract : BottomSheetDialogFragment()