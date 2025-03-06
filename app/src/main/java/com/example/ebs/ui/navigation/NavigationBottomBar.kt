package com.example.ebs.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import dev.chrisbanes.haze.ExperimentalHazeApi
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials


@OptIn(ExperimentalHazeMaterialsApi::class, ExperimentalHazeApi::class)
@Composable
fun BottomNavigation(
    hazeState: HazeState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .hazeEffect(
                state = hazeState,
                style = HazeMaterials.thin(MaterialTheme.colorScheme.surface).copy(
                    blurRadius = 10.dp
                )
            ){
                blurEnabled = true
            }
            .fillMaxWidth()
            .padding(20.dp)
    ){
        content()
    }
}

@Composable
fun BottomNavigationItem(
    navItem: NavigationDestination<out Any>,
    selected: Boolean = false,
    navController: NavController
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                navController.navigate(navItem.route) {
                    popUpTo(
                        navController.graph.findStartDestination().id
                    ) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
    ) {
        Icon(
            painterResource(navItem.icon!!),
            contentDescription = navItem.name,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(navItem.name)
    }
}