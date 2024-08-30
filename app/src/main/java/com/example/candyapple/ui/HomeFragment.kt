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
import com.google.android.material.switchmaterial.SwitchMaterial


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

    }

    private fun observeViewModel() {
        viewModel.egoSwitchState.observe(viewLifecycleOwner) { isChecked ->

        }

        viewModel.switchStates.observe(viewLifecycleOwner) { switchStates ->
            updateSwitchImages(switchStates)
        }

        viewModel.activeSwitches.observe(viewLifecycleOwner) { activeSwitches ->
            updateBottomNavMenu(activeSwitches)
        }
    }

    private fun initializeState() {
        viewModel.updateEgoSwitchState(true)
    }

    private fun updateSwitches(switchStates: Map<Int, Boolean>) {
        binding.swthappines.isChecked = switchStates[R.id.swthappines] ?: false
        binding.swtoptimism.isChecked = switchStates[R.id.swtoptimism] ?: false
        binding.swtkindess.isChecked = switchStates[R.id.swtkindess] ?: false
        binding.swtgiving.isChecked = switchStates[R.id.swtgiving] ?: false
        binding.swtrespect.isChecked = switchStates[R.id.swtrespect] ?: false
    }

    private fun updateBottomNavMenu(activeSwitches: Set<Int>) {
        val menu = bottomNavView.menu
        menu.clear()

        menu.add(Menu.NONE, R.id.homeFragment, Menu.NONE, "Home")
            .setIcon(R.drawable.smile)

        for (i in activeSwitches.take(5)) {
            val label = when (i) {
                R.id.swthappines -> "Happiness"
                R.id.swtoptimism -> "Optimism"
                R.id.swtkindess -> "Kindness"
                R.id.swtgiving -> "Giving"
                R.id.swtrespect -> "Respect"
                else -> "Unknown"
            }
            menu.add(Menu.NONE, i, Menu.NONE, label)
                .setIcon(R.drawable.smile)

        }
    }


    private fun updateSwitchImages(switchStates: Map<Int, Boolean>) {

        val happinessSwitch = binding.swthappines
        updateImage(happinessSwitch, 1)

        val optimismSwitch = binding.swtoptimism
        updateImage(optimismSwitch, 2)

        val kindessSwitch = binding.swtkindess
        updateImage(kindessSwitch, 3)

        val givingSwitch = binding.swtgiving
        updateImage(givingSwitch, 4)

        val respectSwitch = binding.swtrespect
        updateImage(respectSwitch, 5)

        val egoSwitch = binding.swtego
        updateImage(egoSwitch, 6)


    }

    private fun updateImage(switchView: SwitchMaterial, imageIndex: Int) {
        val imageId = when (imageIndex) {
            1 -> if (switchView.isChecked) R.drawable.open else R.drawable.close
            2 -> if (switchView.isChecked) R.drawable.kalpopen2 else R.drawable.kalpclose2
            3 -> if (switchView.isChecked) R.drawable.fopen else R.drawable.fclose
            4 -> if (switchView.isChecked) R.drawable.kalpopen3 else R.drawable.kalpclose3
            5 -> if (switchView.isChecked) R.drawable.apencat else R.drawable.cloecat
            6 -> if (switchView.isChecked) R.drawable.egoclose else R.drawable.egoclose
            else -> R.drawable.egoclose
        }
        when (imageIndex) {
            1 -> binding.imageView.setImageResource(imageId)
            2 -> binding.imageView2.setImageResource(imageId)
            3 -> binding.imageView4.setImageResource(imageId)
            4 -> binding.imageView5.setImageResource(imageId)
            5 -> binding.imageView6.setImageResource(imageId)
            6 -> binding.imageView7.setImageResource(imageId)
        }
    }


}