package com.example.main_page.rep

import javax.inject.Inject

interface MainPageRepo {
    fun printHash(): String
}

class MainPageRepoImpl @Inject constructor(): MainPageRepo  {

    override fun printHash(): String {
        return this.hashCode().toString()
    }
}