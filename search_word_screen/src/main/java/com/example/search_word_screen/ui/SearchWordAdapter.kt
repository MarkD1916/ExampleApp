package com.example.search_word_screen.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.search_word_screen.models.SearchWord
import com.example.search_word_screen.ui.holders.SimpleWordViewHolder

class SearchWordAdapter : ListAdapter<SearchWord, SimpleWordViewHolder>(DIFF_UTIL) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleWordViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SimpleWordViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object {

        private class SearchWordDiffUtil : DiffUtil.ItemCallback<SearchWord>() {

            override fun areItemsTheSame(oldItem: SearchWord, newItem: SearchWord): Boolean =
                oldItem.hashCode() == newItem.hashCode()

            override fun areContentsTheSame(oldItem: SearchWord, newItem: SearchWord): Boolean =
                oldItem == newItem

        }

        private val DIFF_UTIL = SearchWordDiffUtil()

    }

}