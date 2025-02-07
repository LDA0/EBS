package com.example.ebs.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.example.ebs.ui.home.ProfileScreen
import com.example.ebs.ui.starter.SignInScreen
import com.example.ebs.ui.starter.SignUpScreen
import com.example.ebs.ui.starter.WelcomeScreen

fun NavGraphBuilder.mainNav(
    onNavigateSignInFromSignUp: () -> Unit,
    onNavigateSignUpFromSignIn: () -> Unit,
    onNavigateSignInFromWelcome: () -> Unit,
    onNavigateSignUpFromWelcome: () -> Unit,
    onNavigateMenuFromSignIn: () -> Unit,
    onNavigateMenuFromSignUp: () -> Unit,
    onOpenDialogueSetting: () -> Unit
){
    composable<Welcome>{
        WelcomeScreen(onNavigateSignInFromWelcome,onNavigateSignUpFromWelcome)
    }
    composable<SignIn> { navBackStackEntry ->
//        val profile: SignIn = navBackStackEntry.toRoute()
//        ProfileScreen(
//            profile = profile,
//            onNavigateSignIn
//        )
        SignInScreen(onNavigateMenuFromSignIn,onNavigateSignUpFromSignIn)
    }
    composable<SignUp> {
        SignUpScreen(onNavigateMenuFromSignUp,onNavigateSignInFromSignUp)
    }
    composable<Home> {
        ProfileScreen(onOpenDialogueSetting)
    }
    dialog<Settings> {

    }
}