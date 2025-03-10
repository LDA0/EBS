package com.example.ebs.ui.dashboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ebs.data.repositories.remote.DataTestRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DashboardViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: DataTestRepository
) : ViewModel() {
    var counter = MutableStateFlow(0)
        private set

    init {
        viewModelScope.launch {
            count()
        }
    }
    suspend fun count() {
        for (i in 0..10) {
            counter.update { it + i }
            delay(5000)
        }
    }
}
