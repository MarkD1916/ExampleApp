package com.example.main_page.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.core.navigationManager
import com.example.core.ui.UiConstants.CLICKABLE_SCALE_DEGREE
import com.example.core.ui.ext.onClickWithScaleAnimate
import com.example.core.ui.ext.viewModelWithFactory
import com.example.core.ui.views.navigation.NavigationLayoutView
import com.example.feature_blocker.RestrictionFeatureContract
import com.example.main_page.MainPageAction
import com.example.main_page.MainPageContract
import com.example.main_page.R
import com.example.main_page.di.DaggerMainPageComponent
import com.example.main_page.di.MainPageComponent
import com.example.main_page.di.MainPageComponentProvider
import com.example.main_page.setupFeature
import com.example.navigation.InstanceOfFragment
import com.example.navigation.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


interface MainScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = MainPageFragment()
    }
}

class MainPageFragment : MainPageContract(), MainScreenInterface, MainPageAction,
    MainPageComponentProvider {

    private lateinit var viewModel: MainPageViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        provideMainPageComponent()

    }

    private lateinit var coroutineScope: CoroutineScope
    private lateinit var mainPageComponent: MainPageComponent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        coroutineScope = CoroutineScope(Dispatchers.Main)

        viewModel =  viewModelWithFactory(mainPageComponent.getMainPageViewModel().create(50))
        Log.d("LOL", "onCreateView: ${viewModel.hashCode()}, ${viewModel.test()}")
        return inflater.inflate(R.layout.fragment_main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFeature()
    }

    override fun onStart() {
        super.onStart()
        coroutineScope.launch {
            when (val action = viewModel.event.receive()) {
                is Navigate -> goTo(action.route)
            }
        }
    }

    override fun initViews() {
        state.apply {
            navigateToAuthScreenButton?.view = view?.findViewById(R.id.nav_button)
            navigateToAuthScreenButton?.view?.onClickWithScaleAnimate(
                scaleDegree = CLICKABLE_SCALE_DEGREE,
                onClick = { viewModel.navigate(Routes.AUTH_SCREEN) }
            )
            navigateToSearchScreenButton?.view = view?.findViewById(R.id.nav_button_search_word)
            navigateToSearchScreenButton?.view?.onClickWithScaleAnimate(
                scaleDegree = CLICKABLE_SCALE_DEGREE,
                onClick = { viewModel.navigate(Routes.SEARCH_SCREEN) }
            )
        }
    }

    override fun block(isFeatureActive: Boolean) {
        if (!isFeatureActive) {
            val restrictionBottomSheet = RestrictionFeatureContract.newInstance()
            RestrictionFeatureContract.onDismissAction = { navigationManager().closeApp() }
            restrictionBottomSheet.show(this.childFragmentManager, RestrictionFeatureContract.TAG)
        }
    }

    override fun onError(message: Int?) = block(false)

    override fun goTo(route: Routes) {
        navigationManager().addFragmentWithClearVm(route, TAG)
    }

    override fun provideMainPageComponent() {
        if (!this::mainPageComponent.isInitialized) {
            mainPageComponent = DaggerMainPageComponent.create()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        coroutineScope.cancel()
    }
}