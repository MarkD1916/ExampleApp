package com.example.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core.ui.NavigationLayoutView
import com.example.core.ui.ScaleDirectionType
import com.example.core.ui.UiConstants.CLICKABLE_SCALE_DEGREE
import com.example.core.ui.onClickWithScaleAnimate

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainPageFragment : Fragment() {
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

        }
    }

    companion object {
        const val TAG = "MainPageFragment"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}