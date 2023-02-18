package com.example.feature_blocker.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature_blocker.R
import com.example.feature_blocker.RestrictionFeatureContract
import com.example.navigation.NavigationManager

class RestrictionBottomSheet : RestrictionFeatureContract() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.restriction_bottom_sheet_layout, container, false)

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        onDismissAction?.invoke() ?: throw Exception("You must put action if feature unavailable")
    }

}