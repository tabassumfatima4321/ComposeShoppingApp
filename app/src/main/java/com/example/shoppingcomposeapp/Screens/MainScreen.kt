package com.example.shoppingcomposeapp.Screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shoppingcomposeapp.BottomBar.BottomBarNavigationItem
import com.example.shoppingcomposeapp.BottomBar.BottomNavGraph

@Composable
fun MainScreen(navHostController:NavHostController)
{
 /*   Scaffold(
        bottomBar ={ BottomNavGraph(navController = navHostController)}
    )
    {
        BottomNavGraph(navController = navHostController)
    }*/
}

@Composable
fun BottomBar(navHostController: NavHostController) {

    val screens=listOf(BottomBarNavigationItem.Home, BottomBarNavigationItem.Cart,
   BottomBarNavigationItem.Profile,BottomBarNavigationItem.Setting )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination=navBackStackEntry?.destination
    BottomNavigation {
        screens.forEach {screen->
            AddItem(screen = screen, currentDestination =currentDestination
                , navHostController = navHostController)
        }
        
    }
}

@Composable
fun RowScope.AddItem(
    screen:BottomBarNavigationItem,
    currentDestination:NavDestination?,
    navHostController: NavHostController
)
{
    BottomNavigationItem(label={
        Text(text = screen.title)
    },
        icon={
            Icon(imageVector = screen.icon, contentDescription = "navigation icon")

        },
        selected = currentDestination?.hierarchy?.any {
            it.route==screen.route }==true,
        onClick = {
            navHostController.navigate(screen.route)
        }
    )

}
