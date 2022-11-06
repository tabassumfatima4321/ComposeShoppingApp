package com.example.shoppingcomposeapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shoppingcomposeapp.BottomBar.BottomBarNavigationItem
import com.example.shoppingcomposeapp.BottomBar.BottomNavGraph
import com.example.shoppingcomposeapp.ui.theme.LightPink

@Composable
fun MainScreen()
{
    val navController = rememberNavController()
    Scaffold(bottomBar ={ BottomBarApp(navHostController = navController) }
    , backgroundColor = Color.LightGray){
        Box(modifier = Modifier.padding(it))
        {
            BottomNavGraph(navController = navController)

        }
    }

}

@Composable
fun BottomBarApp(navHostController: NavHostController) {

    val screens=listOf(BottomBarNavigationItem.Home, BottomBarNavigationItem.Cart,
   BottomBarNavigationItem.Profile,BottomBarNavigationItem.Setting )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination=navBackStackEntry?.destination
    BottomNavigation(
        modifier = Modifier.graphicsLayer {
        shape= RoundedCornerShape( topStart = 20.dp, topEnd = 20.dp)
        clip=true
    }, backgroundColor = Color.White, contentColor = Color.LightGray
    ) {
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
    BottomNavigationItem(label={ Text(text = screen.title) }
        , icon={ Icon(imageVector = screen.icon, contentDescription = "navigation icon") },
        selected = currentDestination?.hierarchy?.any {
            it.route==screen.route }==true,
        onClick = {
            navHostController.navigate(screen.route)
        }
    , selectedContentColor = LightPink,
        unselectedContentColor = Color.LightGray.copy(0.4f)
    )

}
