package com.example.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.navigation.ui.screens.AddNewUserScreen
import com.example.navigation.ui.screens.HomeScreen
import com.example.navigation.ui.screens.SecondScreen


@Composable
fun ManNavHost(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screens.Home
    ) {
        composable<Screens.Home> {
            HomeScreen(navController= navController )
        }

        composable<Screens.AddUser> {
            AddNewUserScreen(navController = navController)
        }


        composable<Screens.Details> { backStackEntry ->
            val args = backStackEntry.toRoute<Screens.Details>()
            val id: Int = args.id

            SecondScreen(
                id= id,
               navController=navController
            )
        }
    }
}

