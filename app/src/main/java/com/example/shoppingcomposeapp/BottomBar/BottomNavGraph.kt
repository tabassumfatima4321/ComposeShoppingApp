package com.example.shoppingcomposeapp.BottomBar

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoppingcomposeapp.Screens.CartScreen
import com.example.shoppingcomposeapp.Screens.HomeScreen
import com.example.shoppingcomposeapp.Screens.ProfileScreen
import com.example.shoppingcomposeapp.Screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController)
{
    NavHost(navController,
        startDestination =BottomBarNavigationItem.Home.route)
    {
        composable(route=BottomBarNavigationItem.Home.route)
        {
            HomeScreen()
        }
        composable(route=BottomBarNavigationItem.Cart.route)
        {
            CartScreen()
        }
        composable(route=BottomBarNavigationItem.Profile.route)
        {
            ProfileScreen()
        }
        composable(route=BottomBarNavigationItem.Setting.route)
        {
            SettingsScreen()
        }
    }
}
