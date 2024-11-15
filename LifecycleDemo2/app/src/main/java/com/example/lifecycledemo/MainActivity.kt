package com.example.lifecycledemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.nio.file.WatchEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Mensagem de log e Toast para OnCreate
        Log.d("App", "OnCreate chamado")
        Toast.makeText(this, "OnCreateChamado", Toast.LENGTH_SHORT).show()


//        setContent {
//            MyApplicationLifeCycleDemoTheme{
//                Scaffold(modifier = WatchEvent.Modifier)
//            }
//
//        }
    }

    override fun onStart(){
        super.onStart()

        //Mensagem de log para onStart
        Log.d("App", "OnStart chamado")
        Toast.makeText(this, "OnStart chamado", Toast.LENGTH_SHORT).show()
    }


    override fun onPause(){
        super.onPause()

        //Mensagem de log e toast para OnPause
        Log.d("App", "OnPause chamado")
        Toast.makeText(this, "OnPause chamado", Toast.LENGTH_SHORT).show()

    }

    override fun onStop(){
        super.onStop()

        //Mensagem de Log e Toast para OnStop
        Log.d("App", "OnStop chamado")
        Toast.makeText(this, "OnStop chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy(){
        super.onDestroy()

        //Mensagem de log e toast para OnDestroy
        Log.d("App", "OnDestroy chamado")
        Toast.makeText(this, "OnDestroy chamado", Toast.LENGTH_SHORT).show()
    }


}

