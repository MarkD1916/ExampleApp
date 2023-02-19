package com.example.auth_screen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthScreenViewModel @Inject constructor(): ViewModel() {

    private val _blockScreenMutableLiveData = MutableLiveData<Boolean>()
    val blockScreenMutableLiveData: LiveData<Boolean> = _blockScreenMutableLiveData

    fun block(isFeatureActive: Boolean) = _blockScreenMutableLiveData.postValue(isFeatureActive)

}