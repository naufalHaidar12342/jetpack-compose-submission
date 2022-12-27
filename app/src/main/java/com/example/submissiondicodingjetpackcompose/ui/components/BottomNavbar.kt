package com.example.submissiondicodingjetpackcompose.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.submissiondicodingjetpackcompose.R
import com.example.submissiondicodingjetpackcompose.ui.navigation.Menu
import com.example.submissiondicodingjetpackcompose.ui.navigation.NavigationItem

@Composable
fun BottomNavigationBar(
    modifier: Modifier=Modifier,
    navController: NavHostController
){
    BottomNavigation(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute=navBackStackEntry?.destination?.route

        val navigationItem= listOf(
            NavigationItem(
                icon = Icons.Default.Home,
                menu = Menu.Home,
                title = stringResource(R.string.menu_home)
            ),
            NavigationItem(
                icon = Icons.Default.AccountCircle,
                menu = Menu.Profile,
                title = stringResource(R.string.menu_profile),
            ),
        )

        BottomNavigation() {
            navigationItem.map { menuItem->
                BottomNavigationItem(
                    selected = currentRoute==menuItem.menu.route,
                    onClick = {
                              navController.navigate(menuItem.menu.route){
                                  popUpTo(
                                      navController.graph.findStartDestination().id
                                  ){
                                      saveState=true
                                  }

                                  restoreState=true
                                  launchSingleTop=true
                              }
                    },
                    icon = {
                        Icon(
                            imageVector = menuItem.icon,
                            contentDescription = menuItem.title
                        )
                    },
                    label = {
                        Text(text = menuItem.title)
                    }
                )
            }
        }
    }
}