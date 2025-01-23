package com.example.msnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.msnapp.data.local.dao.database.AppDatabase
import com.example.msnapp.repository.MessageRepository
import com.example.msnapp.ui.theme.MsnAppTheme
import com.example.msnapp.ui.theme.view.MessageApp
import com.example.msnapp.ui.viewmodel.MessageViewModel
import com.example.msnapp.ui.viewmodel.MessageViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "msn-db"
        ).fallbackToDestructiveMigration().build()

        val repository = MessageRepository(db.messageDao())

        setContent {
                MsnAppTheme {
                    val viewModel: MessageViewModel = viewModel(factory = MessageViewModelFactory(repository))
                    MessageApp(viewModel)
                }
        }
    }
}
