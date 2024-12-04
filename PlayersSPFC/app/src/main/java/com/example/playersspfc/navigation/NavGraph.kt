package com.example.playersspfc.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.playersspfc.ui.screens.PlayersScrreen
import com.example.playersspfc.ui.screens.HomeScreen
import com.example.playersspfc.models.playersList


@ExperimentalMaterial3Api
@Composable
fun NavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onPlayersSelected = { player ->
                navController.navigate("player/${player.name}")
            })
        }
        composable("player/{player}") { backStackEntry ->
            val playerName = backStackEntry.arguments?.getString("player")
            val selectedPlayer = playersList.first { it.name == playerName }
            PlayersScrreen(selectedPlayer)
        }
    }
}