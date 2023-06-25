package com.example.main_page.ui

import android.util.Log
import com.example.core.ui.base.BaseAction
import com.example.core.ui.base.BaseViewModel
import com.example.main_page.rep.MainPageRepo
import com.example.navigation.Routes
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

data class Navigate(val route: Routes = Routes.UNKNOWN) : BaseAction

class MainPageViewModel @AssistedInject constructor(
    private val repo: MainPageRepo,
    @Assisted val foo: Int
) : BaseViewModel() {

    fun test() {
        Log.d("LOL", "test: ${repo.printHash()}, $foo")
    }

    fun navigate(rote: Routes) {
        coroutineScope.launch {
            event.send(Navigate(rote))
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()

        Log.d("LOL", "onCleared: ")
    }

    @AssistedFactory
    interface MainPageViewModelFactory {
        fun create(foo: Int): MainPageViewModel
    }

}
