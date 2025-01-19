package com.example.postapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.apppost.ui.screens.UserScreen
import com.example.postapp.ui.screens.PostScreen
import com.example.postapp.ui.theme.Pink40

// Classe principal da atividade
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen() // Configura a tela principal da aplicação
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter") // Suprime aviso sobre padding padrão não utilizado
@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    var showMenu by remember { mutableStateOf(false) } // Estado para controlar a exibição do menu

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("PostGram") },
                backgroundColor = Pink40,
                contentColor = Color.White,
                actions = {
                    // Ícone de menu de três pontinhos
                    IconButton(onClick = { showMenu = true }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Menu"
                        )
                    }
                    // DropdownMenu para exibir opções
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(onClick = {
                            showMenu = false
                            // Ação para Configurações
                        }) {
                            Text("Configurações")
                        }
                        DropdownMenuItem(onClick = {
                            showMenu = false
                            // Ação para Ajuda
                        }) {
                            Text("Ajuda")
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Pink40
            ) {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Usuários") },
                    label = { Text("Usuários") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Posts") },
                    label = { Text("Posts") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 }
                )
            }
        }
    ) {
        when (selectedTab) {
            0 -> UserScreen()
            1 -> PostScreen()
        }
    }
}
