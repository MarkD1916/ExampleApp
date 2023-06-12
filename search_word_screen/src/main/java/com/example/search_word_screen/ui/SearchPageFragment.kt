package com.example.search_word_screen.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.navigationManager
import com.example.feature_blocker.RestrictionFeatureContract
import com.example.navigation.InstanceOfFragment
import com.example.search_word_screen.R
import com.example.search_word_screen.SearchPageAction
import com.example.search_word_screen.SearchPageContract
import com.example.search_word_screen.setupFeature
import java.io.PipedReader
import java.io.PipedWriter

interface SearchScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = SearchPageFragment()
    }
}

class SearchPageFragment : SearchPageContract(), SearchScreenInterface, SearchPageAction {



    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("run: ${Thread.currentThread().name}, ${Thread.activeCount()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_search_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFeature()
        setupObservers()
    }

    private fun setupObservers() {
        state.searchTextView?.listenText {
            Log.d("LOL", "setupObservers: $it")
        }
    }

    override fun initViews() {
        state.apply {
            searchTextView = view?.findViewById(R.id.search_view)
            searchRv = view?.findViewById(R.id.search_word_rv)
        }
    }

    override fun block(isFeatureActive: Boolean) {
        if (!isFeatureActive) {
            val restrictionBottomSheet = RestrictionFeatureContract.newInstance()
            RestrictionFeatureContract.onDismissAction = { navigationManager().goToAppInitialScreen() }
            restrictionBottomSheet.show(this.childFragmentManager, RestrictionFeatureContract.TAG)
        }
    }

    override fun onError(message: Int?) = block(false)

}