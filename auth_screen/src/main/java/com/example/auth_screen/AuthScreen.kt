package com.example.auth_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation.InstanceOfFragment

interface AuthScreenInterface : InstanceOfFragment {
    companion object {
        @JvmStatic
        fun newInstance() = AuthScreen()
    }
}

class AuthScreen : Fragment(), AuthScreenInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_auth_screen, container, false)
}