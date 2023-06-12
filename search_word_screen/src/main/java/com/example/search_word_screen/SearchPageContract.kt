package com.example.search_word_screen

import androidx.annotation.StringRes
import androidx.core.view.allViews
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.core.FeatureActive
import com.example.core.ui.base.BaseState
import com.example.core.ui.views.SearchTextView

interface SearchPageAction {


}

data class SearchPageState(
    var searchTextView: SearchTextView? = null,
    var searchRv: RecyclerView? = null
) : BaseState.FragmentUI

abstract class SearchPageContract : Fragment() {

    val state = SearchPageState()

    open val isFeatureActive: Boolean = FeatureActive.IS_SEARCH_PAGE_FEATURE_ACTIVE
    abstract fun block(isFeatureActive: Boolean)
    abstract fun initViews()

    fun checkAllViewsNotNull() {
        this.view?.allViews ?: throw Exception("some view in fragment is null")
    }

    abstract fun onError(@StringRes message: Int?)

}

fun SearchPageContract.setupFeature() {
    try {
        block(isFeatureActive)
        checkAllViewsNotNull()
        initViews()
    } catch (e: Exception) {
        e.printStackTrace()
        onError(com.google.android.material.R.string.error_icon_content_description)
    }
}