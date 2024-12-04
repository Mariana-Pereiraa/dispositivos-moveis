package com.example.playersspfc.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.playersspfc.models.Players
import com.example.playersspfc.models.playersList
import com.example.playersspfc.ui.components.PlayersListItem
import java.nio.file.WatchEvent

@Composable
fun HomeScreen(onPlayersSelected: (Players) -> Unit){
    var searchQuery by remember { mutableStateOf("") }
    val filterPlayers = remember (searchQuery) {
        playersList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    Column {
        TextField(
            value = searchQuery,
            onValueChange = {searchQuery = it},
            label = { Text("Pesquisar")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 8.dp)
        ){
            items(filterPlayers) { players ->
                PlayersListItem(players, onPlayersSelected)
            }
        }
    }
}