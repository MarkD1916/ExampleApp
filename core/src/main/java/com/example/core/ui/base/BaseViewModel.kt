package com.example.core.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel

abstract class BaseViewModel : ViewModel() {

    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    val event = Channel<BaseAction>()

}

interface BaseAction