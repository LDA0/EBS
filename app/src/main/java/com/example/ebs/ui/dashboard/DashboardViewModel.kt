package com.example.ebs.ui.dashboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ebs.data.repositories.remote.DataTestRepository

class DashboardViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: DataTestRepository
) : ViewModel() {

}
