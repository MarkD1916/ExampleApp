package com.example.auth_screen.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.auth_screen.AuthPageContract
import com.example.auth_screen.R
import com.example.auth_screen.di.AuthComponentProvider
import com.example.auth_screen.di.AuthScreenComponent
import com.example.auth_screen.di.DaggerAuthScreenComponent
import com.example.core.di.CoreInjectHelper
import com.example.core.navigationManager
import com.example.feature_blocker.RestrictionFeatureContract
import com.example.navigation.InstanceOfFragment

interface AuthScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = AuthScreen()
    }
}

class AuthScreen : AuthPageContract(), AuthScreenInterface, AuthComponentProvider {

    private lateinit var authScreenComponent: AuthScreenComponent
    private lateinit var restrictionBottomSheet: RestrictionFeatureContract
    private val viewModel: AuthScreenViewModel by lazy {
        authScreenComponent.getAuthScreenViewModel()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        provideAuthScreenComponent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        restrictionBottomSheet = RestrictionFeatureContract.newInstance()
        RestrictionFeatureContract.onDismissAction = { navigationManager().goBack() }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_auth_screen, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) block(isFeatureActive)

        viewModel.blockScreenMutableLiveData.observe(viewLifecycleOwner) {
            restrictionBottomSheet.show(this.childFragmentManager, RestrictionFeatureContract.TAG)
        }
    }

    override fun provideAuthScreenComponent(): AuthScreenComponent {
        if (!this::authScreenComponent.isInitialized) {
            authScreenComponent = DaggerAuthScreenComponent
                .builder()
                .authScreenComponent(this)
                .coreComponent(CoreInjectHelper.provideCoreComponent(requireActivity().application))
                .build()
        }
        return authScreenComponent
    }

    override fun block(isFeatureActive: Boolean) {
        if (!isFeatureActive) {
            viewModel.block(isFeatureActive)
        }
    }

}