package com.example.noteapp.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noteapp.presenter.screens.main.MainScreen

sealed class Screens(val rout:String){
    object MainScreenType: Screens(rout = "main_screen")
}

@Composable
fun SetupNavHost(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Screens.MainScreenType.rout ){
        composable(route = Screens.MainScreenType.rout){
            MainScreen(navHostController = navHostController)
        }
    }
}
