package com.example.auth_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.auth_screen.AuthPageContract
import com.example.auth_screen.R
import com.example.feature_blocker.RestrictionFeatureContract
import com.example.navigation.InstanceOfFragment

interface AuthScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = AuthScreen()
    }
}

class AuthScreen : AuthPageContract(), AuthScreenInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_auth_screen, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        block(isFeatureActive)
    }

    override fun block(isFeatureActive: Boolean) {
        if (!isFeatureActive) {
            val restrictionBottomSheet = RestrictionFeatureContract.newInstance()
            restrictionBottomSheet.show(this.childFragmentManager, RestrictionFeatureContract.TAG)
        }
    }

}