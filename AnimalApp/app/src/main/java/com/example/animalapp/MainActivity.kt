package com.example.animalapp

import android.net.Uri
import android.widget.VideoView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.animalapp.ui.theme.AnimalAppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalAppTheme {
                AnimalApp()
            }
        }
    }
}

class VideoPlayerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val videoRes = intent.getIntExtra("videoRes", R.raw.cavalo)
            AndroidView(
                factory = { context ->
                            VideoView(context).apply {
                                setVideoURI(Uri.parse("android.resource://$packageName/$videoRes"))
                                start()
                            }
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Composable
fun AnimalAppMenu(onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = "Menu")
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false}
    ) {
        DropdownMenuItem(
            text = { Text("Cavalo")},
            onClick = {
                expanded = false
                onOptionSelected("Cavalo")
            }
        )

        DropdownMenuItem(
            text = { Text("Papagaio")},
            onClick = {
                expanded = false
                onOptionSelected("Papagaio")
            }
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(onAnimalSelected: (String) -> Unit) {
    Scaffold  (
        topBar = {
            TopAppBar(
                title = { Text("AnimalApp")},
                actions = {
                    AnimalAppMenu(onOptionSelected = onAnimalSelected)
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
                contentAlignment = Alignment.Center
        ) {
            Text("Selecione um animal no menu.")
        }

    }
}


@Composable
fun AnimalScreen(animal: String){
    val context = LocalContext.current
    val imageRes =
        if(animal == "Cavalo") R.drawable.cavalo
        else R.drawable.papagaio

    val soundRes =
        if (animal == "Cavalo") R.raw.cavalo_relinchando
        else R.raw.papagaio_falando

    val videoRes =
        if (animal == "Cavalo") R.raw.cavalo
        else R.raw.papagaio

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        //imagem do animal
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "$animal Image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))

        //reproduzir som
        Button(onClick = {
            try {
                val mediaPlayer = MediaPlayer.create(context, soundRes)
                if (mediaPlayer != null){
                    mediaPlayer.start()
                    mediaPlayer.setOnCompletionListener{
                        mediaPlayer.release()
                    }
                } else {
                    println("Erro: MediaPlayer retornou nulo para o recurso $soundRes")
                }
            } catch (e: Exception){
                println("Erro ao inicializar o MediaPlayer: ${e.message}")
            }
        }
        ) {
            Text("Reproduzir som")
        }
        Spacer(modifier = Modifier.height(16.dp))

        //botão do video
        Button(onClick = {
            val intent = Intent(context, VideoPlayerActivity::class.java)
            intent.putExtra("videoRes", videoRes)
            context.startActivity(intent)
        }
        ) {
            Text("Reproduzir Vídeo")
        }
    }

}

//navegação entre telas
@ExperimentalMaterial3Api
@Composable
fun AnimalApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onAnimalSelected = { animal ->
                navController.navigate("animal/$animal")
            })
        }
        composable(
            "animal/{animal}",
            arguments = listOf(navArgument("animal") { type = NavType.StringType })
        ) { backStackEntry ->
            val animal = backStackEntry.arguments?.getString("animal") ?: "Cavalo"
            AnimalScreen(animal)
        }
    }
}

