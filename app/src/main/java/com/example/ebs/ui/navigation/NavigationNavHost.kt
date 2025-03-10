package com.example.ebs.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ebs.ui.theme.EBSTheme
import dev.chrisbanes.haze.HazeState

@Composable
fun MyNavigationg(
    signedIn: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val hazeState = remember { HazeState() }

    Scaffold(
        bottomBar = {
            if(signedIn.value) {
                BottomNavigation(
                    hazeState = hazeState
                ){
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    NavigationDestinationList.forEach { navItem ->
                        if (navItem.icon != null) {
                            BottomNavigationItem(
                                navItem,
                                selected = currentDestination
                                    ?.hierarchy
                                    ?.any {
                                        navItem.route == it.route
                                    } == true,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.Welcome,
            modifier = modifier
        ) {
            mainNav(navController,signedIn,hazeState)
        }
    }
}




