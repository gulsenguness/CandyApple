package com.example.candyapple

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.candyapple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navControl: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navControl=navHostFragment.navController
        bottomNavigation()
    }

    private fun bottomNavigation() {
        NavigationUI.setupWithNavController(binding.bottomNav, navControl)

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> navigationToFragment(R.id.homeFragment)
                R.id.swthappines -> navigationToFragment(R.id.happinessFragment)
                R.id.swtoptimism -> navigationToFragment(R.id.optimismFragment)
                R.id.swtkindess -> navigationToFragment(R.id.fragment_kindness)
                R.id.swtgiving -> navigationToFragment(R.id.givingFragment2)
                R.id.swtrespect -> navigationToFragment(R.id.respectFragment)
            }
            true
        }
    }

    private fun navigationToFragment(fragmentId: Int) {
        val navControl = navHostFragment.navController
        navControl.navigate(fragmentId)
    }
}