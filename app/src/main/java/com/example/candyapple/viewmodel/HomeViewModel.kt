package com.example.candyapple.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.candyapple.R

class HomeViewModel : ViewModel() {

    private val _switchStates = MutableLiveData<Map<Int, Boolean>>().apply {
        value = mapOf(
            R.id.swthappines to false,
            R.id.swtoptimism to false,
            R.id.swtkindess to false,
            R.id.swtgiving to false,
            R.id.swtrespect to false
        )
    }
    val switchStates: LiveData<Map<Int, Boolean>> = _switchStates

    private val _egoSwitchState = MutableLiveData<Boolean>().apply { value = true }
    val egoSwitchState: LiveData<Boolean> = _egoSwitchState

    private val activeSwitchOrder = mutableListOf<Int>()

    private val _activeSwitches = MutableLiveData<Set<Int>>().apply { value = emptySet() }
    val activeSwitches: LiveData<Set<Int>> = _activeSwitches

    fun updateSwitchState(switchId: Int, isChecked: Boolean) {
        _switchStates.value = _switchStates.value?.plus(switchId to isChecked)
    }

    fun updateEgoSwitchState(isChecked: Boolean) {
        _egoSwitchState.value = isChecked
    }
}