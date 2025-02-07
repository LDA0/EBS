package com.example.ebs.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ebs.R
import com.example.ebs.ui.components.DarkLightPreviews
import com.example.ebs.ui.theme.EBSTheme

data class NavigationItems<T : Any>(
    val name: String,
    val route: T,
    val icon: Int? = null
)

val NavigationItemList = listOf(
    NavigationItems("Welcome", Welcome),
    NavigationItems("SignUp", SignUp),
    NavigationItems("SignIn", SignIn),
    NavigationItems("Notifikasi", Notifikasi),
    NavigationItems("Home", Home, R.drawable.home_variant_outline),
    NavigationItems("Scan", Scan, R.drawable.scan_helper),
    NavigationItems("Riwayat", Riwayat, R.drawable.view_list_outline),
    NavigationItems("Profile", Profile, R.drawable.account),
    NavigationItems("Profile", Settings)
)

@Composable
fun MyNavigationg(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                NavigationItemList.forEach { navItem ->
                    if (navItem.icon != null) {
                        BottomNavigationItem(
                            icon = {
                                Icon(painterResource(navItem.icon),
                                contentDescription = navItem.name,
                                    tint =  MaterialTheme.colorScheme.onSurfaceVariant)},
                            label = { Text(navItem.name) },
                            selected = currentDestination?.hierarchy?.any {navItem.route == it.route} == true,
                            onClick = {
                                navController.navigate(navItem.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Welcome,
            modifier = modifier
                .padding(innerPadding)
        ) {
            mainNav(
                onNavigateSignInFromSignUp = {
                    navController.navigateWithPopUpTo(SignIn, SignUp)
                },
                onNavigateSignUpFromSignIn = {
                    navController.navigateWithPopUpTo(SignUp, SignIn)
                },
                onNavigateSignInFromWelcome = {
                    navController.navigateWithPopUpTo(SignIn, Welcome)
                },
                onNavigateSignUpFromWelcome = {
                    navController.navigateWithPopUpTo(SignUp, Welcome)
                },
                onNavigateMenuFromSignIn = {
                    navController.navigateWithPopUpTo(Home, SignIn)
                },
                onNavigateMenuFromSignUp = {
                    navController.navigateWithPopUpTo(Home, SignUp)
                },
                onOpenDialogueSetting = {
                    navController.navigateWithPopUpTo(Settings, Home)
                }
            )
        }
    }
}

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    content: @Composable () -> Unit
){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .padding(20.dp)
    ){
        content()
    }
}

@Composable
fun BottomNavigationItem(
    icon: @Composable () -> Unit = {},
    label: @Composable () -> Unit = {},
    selected: Boolean,
    onClick: () -> Unit = {}
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                onClick()
            }
    ) {
        icon()
        label()
    }
}

@DarkLightPreviews
@Composable
fun PreviewMyNavigationg(){
    EBSTheme {
        MyNavigationg()
    }
}


