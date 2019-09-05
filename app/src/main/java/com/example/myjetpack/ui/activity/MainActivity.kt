package com.example.myjetpack.ui.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myjetpack.R
import com.example.myjetpack.ui.fragment.main.HomeFragment
import com.example.myjetpack.ui.fragment.main.MarketFragment
import com.example.myjetpack.ui.fragment.main.MineFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener, MarketFragment.OnFragmentInteractionListener, MineFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = host.navController

        initBottomNavigationView(bottomnavigation_view,navController)
    }

    /**
     * Navigation绑定bottomNavigationView
     */
    private fun initBottomNavigationView(bottomNavigationView: BottomNavigationView, navController: NavController) {
        bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
//                R.id.meFragment -> mCamera.visibility = View.VISIBLE
//                else -> mCamera.visibility = View.GONE
            }
        }
    }
}
