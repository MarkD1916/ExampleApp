package com.example.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core.ui.NavigationLayoutView
import com.example.core.ui.UiConstants.CLICKABLE_SCALE_DEGREE
import com.example.core.ui.onClickWithScaleAnimate
import com.example.navigation.InstanceOfFragment
import com.example.navigation.NavigationManager
import com.example.navigation.Routes

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

interface MainScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = MainPageFragment()
    }
}

class MainPageFragment : Fragment(), MainScreenInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = getView()?.findViewById<NavigationLayoutView>(R.id.nav_button)
        button?.onClickWithScaleAnimate(scaleDegree = CLICKABLE_SCALE_DEGREE) {
            requireActivity().apply {
                (this as NavigationManager).goTo(Routes.AUTH_SCREEN)
            }
        }
    }
}