package com.david.fructus.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.david.fructus.R
import com.david.fructus.databinding.ActivityFructusMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * The Main activity which hosts the NavHostFragment - for managing app navigation
 */
@AndroidEntryPoint
class FructusMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFructusMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /*
        Get the navigation controller through the navHostFragment. As stated in the documentation:
        ---
        When creating the NavHostFragment using FragmentContainerView or if manually adding the
        NavHostFragment to your activity
        via a FragmentTransaction, attempting to retrieve the NavController in onCreate() of an Activity
        via Navigation.findNavController(Activity, @IdRes int) will fail.
        You should retrieve the NavController directly from the NavHostFragment instead.
        ------

         */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val  navController = navHostFragment.navController

        //Set up app bar with navController. This set the toolbar title based on android:label attribute of the
        //destination fragment
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController,appBarConfiguration)
    }
}