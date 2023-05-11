package com.example.search_word_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.navigationManager
import com.example.feature_blocker.RestrictionFeatureContract
import com.example.navigation.InstanceOfFragment
import com.example.navigation.Routes
import com.example.search_word_screen.R
import com.example.search_word_screen.SearchPageAction
import com.example.search_word_screen.SearchPageContract
import com.example.search_word_screen.setupFeature

interface SearchScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = SearchPageFragment()
    }
}

class SearchPageFragment : SearchPageContract(), SearchScreenInterface, SearchPageAction {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_search_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFeature()
    }

    override fun initViews() {

    }

    override fun block(isFeatureActive: Boolean) {
        if (!isFeatureActive) {
            val restrictionBottomSheet = RestrictionFeatureContract.newInstance()
            RestrictionFeatureContract.onDismissAction = { navigationManager().closeApp() }
            restrictionBottomSheet.show(this.childFragmentManager, RestrictionFeatureContract.TAG)
        }
    }

    override fun onError(message: Int?) = block(false)


}