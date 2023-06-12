package com.example.main_page.ui

import com.example.core.ui.base.BaseAction
import com.example.core.ui.base.BaseViewModel
import com.example.navigation.Routes
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class Navigate(val route: Routes = Routes.UNKNOWN): BaseAction

class MainPageViewModel @Inject constructor(): BaseViewModel() {

    fun navigate(rote: Routes) {
        coroutineScope.launch {
            event.send(Navigate(rote))
        }
    }

}