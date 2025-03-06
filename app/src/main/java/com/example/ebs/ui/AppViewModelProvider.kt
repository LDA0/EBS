package com.example.ebs.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ebs.EbsApplication
import com.example.ebs.ui.dashboard.DashboardViewModel
import com.example.ebs.ui.dashboard.DetectionListViewModel
import com.example.ebs.ui.dashboard.ProfileViewModel
import com.example.ebs.ui.dashboard.WasteDetailViewModel
import com.example.ebs.ui.starter.SignInViewModel
import com.example.ebs.ui.starter.SignUpViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            SignInViewModel(EbsApplication().container.itemsRepository)
        }

        initializer {
            SignUpViewModel(EbsApplication().container.itemsRepository)
        }
        initializer {
            DashboardViewModel(
                this.createSavedStateHandle(),
                EbsApplication().container.dataTestRepository
            )
        }

        initializer {
            DetectionListViewModel(EbsApplication().container.dataTestRepository)
        }

        initializer {
            ProfileViewModel(
                this.createSavedStateHandle(),
                EbsApplication().container.dataTestRepository
            )
        }

        initializer {
            WasteDetailViewModel(EbsApplication().container.itemsRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [EbsApplication].
 */
fun CreationExtras.EbsApplication(): EbsApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as EbsApplication)
