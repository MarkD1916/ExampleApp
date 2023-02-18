package com.example.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core.navigationManager
import com.example.core.ui.NavigationLayoutView
import com.example.core.ui.UiConstants.CLICKABLE_SCALE_DEGREE
import com.example.core.ui.onClickWithScaleAnimate
import com.example.main_page.R
import com.example.navigation.InstanceOfFragment
import com.example.navigation.Routes

interface MainScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = MainPageFragment()
    }
}

class MainPageFragment : Fragment(), MainScreenInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = getView()?.findViewById<NavigationLayoutView>(R.id.nav_button)
        button?.onClickWithScaleAnimate(scaleDegree = CLICKABLE_SCALE_DEGREE) {
            navigationManager().goToFeatureInitialScreen(Routes.AUTH_SCREEN)
        }
    }

}