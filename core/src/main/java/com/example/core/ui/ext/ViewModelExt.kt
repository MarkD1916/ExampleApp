package com.example.core.ui.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.ui.base.BaseViewModel

class Factory<T : ViewModel>(private val create: () -> T) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = create.invoke() as T

}

fun <T: BaseViewModel> Fragment.viewModelWithFactory(viewModel: ViewModel): T {
    val mViewModel: BaseViewModel by viewModels {
        Factory {
            viewModel
        }
    }
    return mViewModel as T
}