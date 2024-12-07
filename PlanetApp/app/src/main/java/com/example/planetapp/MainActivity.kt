package com.example.planetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.planetapp.navigation.NavGraph
import com.example.planetapp.ui.theme.PlanetAppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetAppTheme {
                NavGraph(
                    onSettingsClick = {

                    },
                    onHelpClick = {

                    }
                )
            }

        }
    }
}