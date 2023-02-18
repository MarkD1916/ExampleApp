package com.example.feature_blocker

import android.view.View
import com.example.feature_blocker.ui.RestrictionBottomSheet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface BlockingAction {

    fun blockNavigationToFeature(navigationView: View)
    fun blockFeature()

}

interface RestrictionAction {

    fun showRestrictionsTopMessage()
    fun showRestrictionAlert()

}

abstract class RestrictionFeatureContract : BottomSheetDialogFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = RestrictionBottomSheet()
        var onDismissAction: (() -> Unit)? = null
        const val TAG = "RestrictionBottomSheet"
    }

}