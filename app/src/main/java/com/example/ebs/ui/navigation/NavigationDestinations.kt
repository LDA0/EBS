package com.example.ebs.ui.navigation

import com.example.ebs.R
import kotlinx.serialization.Serializable

sealed class Route {
    @Serializable object Welcome
    @Serializable object SignIn
    @Serializable object SignUp
    @Serializable object Notifikasi
    @Serializable object Detail
    @Serializable object Dashboard
    @Serializable object Scan
    @Serializable object Riwayat
    @Serializable object Profile
    @Serializable object Settings
}
data class NavigationDestination<T : Any>(
    val name: String,
    val route: T,
    val icon: Int? = null
)

val NavigationDestinationList = listOf(
    NavigationDestination("Welcome", Route.Welcome),
    NavigationDestination("SignUp", Route.SignUp),
    NavigationDestination("SignIn", Route.SignIn),
    NavigationDestination("Notifikasi", Route.Notifikasi),
    NavigationDestination("Detail", Route.Detail),
    NavigationDestination("Home", Route.Dashboard, R.drawable.home_variant_outline),
    NavigationDestination("Scan", Route.Scan, R.drawable.scan_helper),
    NavigationDestination("Riwayat", Route.Riwayat, R.drawable.view_list_outline),
    NavigationDestination("Profile", Route.Profile, R.drawable.account),
    NavigationDestination("Settings", Route.Settings)
)