package com.example.core.ui.base

import androidx.lifecycle.ViewModel
import com.example.core.di.CoreComponent
import com.example.core.di.CoreComponentProvider
import com.example.core.di.CoreInjectHelper.provideCoreComponent
import com.example.core.di.CoreModule
import com.example.core.di.DaggerCoreComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject
import javax.inject.Named

abstract class BaseViewModel : ViewModel() {

    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    val event = Channel<BaseAction>()

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }

}

interface BaseAction