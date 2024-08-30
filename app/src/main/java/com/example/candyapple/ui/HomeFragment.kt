package com.example.candyapple.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.candyapple.R
import com.example.candyapple.databinding.FragmentHomeBinding
import com.example.candyapple.viewmodel.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var bottomNavView: BottomNavigationView
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.swthappines.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateSwitchState(R.id.swthappines, isChecked)
        }
        updateBottomNavMenu()
    }

    private fun updateBottomNavMenu(activeSwitches: Set<Int>) {
        val menu = bottomNavView.menu
        menu.clear()

        for (i in activeSwitches) {
            val label = when (i) {
                R.id.swthappines -> "Happiness"
                // Add other cases
                else -> "Unknown"
            }
            menu.add(Menu.NONE, i, Menu.NONE, label)
        }
    }


}