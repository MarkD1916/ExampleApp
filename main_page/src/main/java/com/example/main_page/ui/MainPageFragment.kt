package com.example.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.core.navigationManager
import com.example.core.ui.views.navigation.NavigationLayoutView
import com.example.core.ui.UiConstants.CLICKABLE_SCALE_DEGREE
import com.example.core.ui.onClickWithScaleAnimate
import com.example.feature_blocker.RestrictionFeatureContract
import com.example.main_page.MainPageAction
import com.example.main_page.MainPageContract
import com.example.main_page.R
import com.example.main_page.setupFeature
import com.example.navigation.InstanceOfFragment
import com.example.navigation.Routes

interface MainScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = MainPageFragment()
    }
}

class MainPageFragment : MainPageContract(), MainScreenInterface, MainPageAction {

    private var navigateToAuthScreenButton: NavigationLayoutView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_main_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFeature()
    }

    override fun initViews() {
        navigateToAuthScreenButton = view?.findViewById(R.id.nav_button)
        navigateToAuthScreenButton?.onClickWithScaleAnimate(
            scaleDegree = CLICKABLE_SCALE_DEGREE,
            onClick = (this::goToAuthFeature)
        )
    }

    override fun block(isFeatureActive: Boolean) {
        if (!isFeatureActive) {
            val restrictionBottomSheet = RestrictionFeatureContract.newInstance()
            RestrictionFeatureContract.onDismissAction = { navigationManager().closeApp() }
            restrictionBottomSheet.show(this.childFragmentManager, RestrictionFeatureContract.TAG)
        }
    }

    override fun onError(message: Int?) = block(false)
        //Toast.makeText(requireContext(), getText(message), Toast.LENGTH_SHORT).show()

    override fun goToAuthFeature() =
        navigationManager().addFragment(Routes.AUTH_SCREEN)

}