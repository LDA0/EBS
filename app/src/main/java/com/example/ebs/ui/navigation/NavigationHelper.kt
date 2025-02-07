package com.example.ebs.ui.navigation

import androidx.navigation.NavController

fun NavController.navigateWithPopUpTo(
    route: Any,
    popUpToRoute: Any,
    inclusive: Boolean = true,
    saveState: Boolean = true,
    restoreState: Boolean = true
) {
    navigate(route) {
        popUpTo(popUpToRoute) {
            this.inclusive = inclusive
            this.saveState = saveState
        }
        this.restoreState = restoreState
    }
}
fun NavController.justNavigate(route: Any) {
    navigate(route)
}