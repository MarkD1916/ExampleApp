package com.example.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.navigationManager
import com.example.core.ui.NavigationLayoutView
import com.example.core.ui.UiConstants.CLICKABLE_SCALE_DEGREE
import com.example.core.ui.onClickWithScaleAnimate
import com.example.feature_blocker.ui.RestrictionBottomSheet
import com.example.main_page.MainPageAction
import com.example.main_page.MainPageContract
import com.example.main_page.R
import com.example.navigation.InstanceOfFragment
import com.example.navigation.Routes

interface MainScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = MainPageFragment()
    }
}

class MainPageFragment : MainPageContract(), MainScreenInterface, MainPageAction {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        block(isFeatureActive)
        val button = getView()?.findViewById<NavigationLayoutView>(R.id.nav_button)
        button?.onClickWithScaleAnimate(scaleDegree = CLICKABLE_SCALE_DEGREE) {
            goToAuthFeature()
        }
    }

    override fun block(isFeatureActive: Boolean) {
        if (!isFeatureActive) {
            val restrictionBottomSheet = RestrictionBottomSheet()
            restrictionBottomSheet.show(this.childFragmentManager, RestrictionBottomSheet.TAG)
        }
    }

    override fun goToAuthFeature() =
        navigationManager().addFragment(Routes.AUTH_SCREEN)

}