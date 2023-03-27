package ru.mokita.smartlab.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private var _destination: MutableStateFlow<Int?> = MutableStateFlow(null)
    val destination get() = _destination.asStateFlow()



    fun setDestination(destination: Int) {
        _destination.value = destination
    }

}