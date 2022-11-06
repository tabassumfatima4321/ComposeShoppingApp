package com.example.shoppingcomposeapp.BottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarNavigationItem(val route:String, val icon:ImageVector,
                                     val title:String)
{
    object Home:BottomBarNavigationItem("home", Icons.Default.Home,"Home")
    object Cart:BottomBarNavigationItem("cart",Icons.Default.ShoppingCart,"Cart")
    object Profile:BottomBarNavigationItem("profile",Icons.Default.Person,"Profile")
    object Setting:BottomBarNavigationItem("settings",Icons.Default.Settings,"Settings")
}
