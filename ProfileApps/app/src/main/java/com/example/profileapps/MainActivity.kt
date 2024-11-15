package com.example.profileapps

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val nameText = findViewById<TextView>(R.id.nameText)
        val descriptionText = findViewById<TextView>(R.id.descriptionText)
        val currentJobText = findViewById<TextView>(R.id.currentJobText)
        val experienceLayout = findViewById<LinearLayout>(R.id.experienceLayout)


        profileImage.setOnClickListener {
            Toast.makeText(this,"Foto de perfil de Juliana Silva", Toast.LENGTH_SHORT).show()
        }

        profileImage.setImageResource(R.drawable.juliana)

        nameText.text = "Juliana Silva"
        descriptionText.text = "Desenvolvedora Web com 2 anos de experiência"
        currentJobText.text = "Emprego Atual: Desenvolvedora Web no GB"

        val experience = listOf(
            "Desenvolvedora FullStack no IA",
            "Estagiária na Gupy"
        )


        for(experience in experience){
            val textView = TextView(this)
            textView.text = experience
            textView.textSize = 16f
            experienceLayout.addView(textView)
        }

    }
}