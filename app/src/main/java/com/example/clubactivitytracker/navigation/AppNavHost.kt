package com.example.clubactivitytracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clubactivitytracker.ui.theme.pages.accounts.AccountsScreen
import com.example.clubactivitytracker.ui.theme.pages.events.EventsScreen
import com.example.clubactivitytracker.ui.theme.pages.firstaid.FirstAidScreen
import com.example.clubactivitytracker.ui.theme.pages.home.HomeScreen
import com.example.clubactivitytracker.ui.theme.pages.login.LoginScreen
import com.example.clubactivitytracker.ui.theme.pages.training.TrainingScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN){
       NavHost(navController = navController,
    modifier = modifier, startDestination = startDestination){

           composable(ROUTE_LOGIN){
               LoginScreen(navController)
           }

           composable(ROUTE_HOME){
               HomeScreen(navController)
           }

           composable(ROUTE_ACCOUNTS){
               AccountsScreen(navController)
           }

           composable(ROUTE_EVENTS){
               EventsScreen(navController)
           }

           composable(ROUTE_FIRST_AID){
               FirstAidScreen(navController)
           }

           composable(ROUTE_TRAINING){
               TrainingScreen(navController)
           }

           composable(ROUTE_SIGNUP){
               TrainingScreen(navController)
           }

       }
    }
