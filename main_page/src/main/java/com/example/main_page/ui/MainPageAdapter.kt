package com.example.main_page.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.core.R
import com.example.main_page.models.MainPageActions
import com.example.main_page.models.MainPageHolders
import com.example.navigation.Routes

interface AdapterActionListener {

    fun navButtonClick(routes: Routes)
}

class MainPageAdapter(private val actionListener: AdapterActionListener) : ListAdapter<MainPageActions, MainPageHolders>(DiffUtilsCallback()), View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPageHolders {


        return when (viewType) {
            HolderType.NAVIGATION_BUTTON.ordinal -> {
                val layout = LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.navigation_layout,
                        parent,
                        false
                    ) as LinearLayout
                val title = layout.findViewById<TextView>(R.id.navigation_title)
                layout.rootView.setOnClickListener(this)
                MainPageHolders.NavigationHolder(layout, title)
            }
            else -> throw IllegalStateException()
        }

    }

    override fun onBindViewHolder(holder: MainPageHolders, position: Int) {
        when (holder) {
            is MainPageHolders.NavigationHolder -> {
                val item = getItem(position) as MainPageActions.Navigation
                holder.title.text = item.title
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MainPageActions.Navigation -> {
                HolderType.NAVIGATION_BUTTON.ordinal
            }
        }
    }

    enum class HolderType {
        NAVIGATION_BUTTON
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    class DiffUtilsCallback : DiffUtil.ItemCallback<MainPageActions>() {
        override fun areItemsTheSame(oldItem: MainPageActions, newItem: MainPageActions): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(
            oldItem: MainPageActions,
            newItem: MainPageActions
        ): Boolean {
            return oldItem == newItem
        }
    }
}