package com.example.myjetpack.ui.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myjetpack.R
import com.example.myjetpack.ui.fragment.login.LoginFragment
import com.example.myjetpack.ui.fragment.login.RegisterFragment
import com.example.myjetpack.ui.fragment.login.WellcomeFragment

class LoginActivity : AppCompatActivity() , WellcomeFragment.OnFragmentInteractionListener, LoginFragment.OnFragmentInteractionListener, RegisterFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        Log.e("max","uri"+uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
