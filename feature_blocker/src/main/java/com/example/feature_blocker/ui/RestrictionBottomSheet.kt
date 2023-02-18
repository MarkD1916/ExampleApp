package com.example.feature_blocker.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature_blocker.RestrictionFeatureContract
import com.example.feature_blocker.R
import com.example.navigation.NavigationManager

class RestrictionBottomSheet : RestrictionFeatureContract() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.restriction_bottom_sheet_layout, container, false)

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismissAction?.invoke() ?: requireActivity().apply {
            (this as NavigationManager).goBack()
        }

    }

}