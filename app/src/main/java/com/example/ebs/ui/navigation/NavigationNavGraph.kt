package com.example.ebs.ui.navigation

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.example.ebs.ui.dashboard.DashboardScreen
import com.example.ebs.ui.dashboard.DetailScreen
import com.example.ebs.ui.dashboard.DetectionListScreen
import com.example.ebs.ui.dashboard.ProfileScreen
import com.example.ebs.ui.dashboard.ScanScreen
import com.example.ebs.ui.dialogue.ApplyRequest
import com.example.ebs.ui.starter.SignInScreen
import com.example.ebs.ui.starter.SignUpScreen
import com.example.ebs.ui.starter.WelcomeScreen
import dev.chrisbanes.haze.HazeState

fun NavGraphBuilder.mainNav(navController: NavController, signedIn: MutableState<Boolean>, hazeState: HazeState){
    val navHandler = NavigationHandler(navController)
    composable<Route.Welcome>{
        WelcomeScreen(navHandler)
    }
    composable<Route.SignUp> {
        SignUpScreen(navHandler)
    }
    composable<Route.SignIn> {
        SignInScreen(navHandler, signedIn)
    }
    composable<Route.Dashboard> {
        DashboardScreen(navHandler,hazeState)
    }
    composable<Route.Scan> {
        ScanScreen(navHandler,hazeState)
    }
    composable<Route.Riwayat> {
        DetectionListScreen(navHandler,hazeState)
    }
    composable<Route.Profile> {
        ProfileScreen(navHandler,hazeState)
    }
    composable<Route.Detail> {
        DetailScreen(navHandler)
    }
    dialog<Route.Settings> {
        ApplyRequest()
    }
}

class NavigationHandler(private val navController: NavController) {
    private fun navigateWithPopUpTo(
        route: Any,
        popUpToRoute: Any,
        inclusive: Boolean = true,
        saveState: Boolean = true,
        launchSingleTop: Boolean = true,
        restoreState: Boolean = true
    ) {
        navController.navigate(route) {
            popUpTo(popUpToRoute) {
                this.inclusive = inclusive
                this.saveState = saveState
            }
            this.launchSingleTop = launchSingleTop
            this.restoreState = restoreState
        }
    }
    private fun justNavigate(
        route: Any
    ) {
        navController.navigate(route)
    }
    val signInFromSignUp: () -> Unit = { navigateWithPopUpTo(Route.SignIn, Route.SignUp) }
    val signUpFromSignIn: () -> Unit = { navigateWithPopUpTo(Route.SignUp, Route.SignIn) }
    val signInFromWelcome: () -> Unit = { navigateWithPopUpTo(Route.SignIn, Route.Welcome) }
    val signUpFromWelcome: () -> Unit = { navigateWithPopUpTo(Route.SignUp, Route.Welcome) }
    val menuFromSignIn: () -> Unit = { navigateWithPopUpTo(Route.Dashboard, Route.SignIn) }
    val menuFromSignUp: () -> Unit = { navigateWithPopUpTo(Route.Dashboard, Route.SignUp) }
    val dialogueSetting: () -> Unit = { justNavigate(Route.Settings) }
}
