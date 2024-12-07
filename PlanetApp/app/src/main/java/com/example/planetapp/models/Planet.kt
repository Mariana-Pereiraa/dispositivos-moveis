package com.example.planetapp.models

import com.example.planetapp.R
data class Planet (
    val id: Int,
    val name: String,
    val type: String,
    val galaxy: String,
    val distanceFromSun: String,
    val diameter: String,
    val characteristics: String,
    val imageRes: Int,
    var isFavorite: Boolean = false
)

val planetList = listOf(
    Planet(
        id = 1,
        name = "Terra",
        type = "Terrestre",
        galaxy = "Via Láctea",
        distanceFromSun = "149.6 milhões km",
        diameter = "12,742 km",
        characteristics = "Suporta vida, água e atmosfera.",
        imageRes = R.drawable.terra
    ),
    Planet(
        id = 2,
        name = "Marte",
        type = "Terrestre",
        galaxy = "Via Láctea",
        distanceFromSun = "227.9 milhões km",
        diameter = "6,779 km",
        characteristics = "Possui atmosfera fina e água congelada.",
        imageRes = R.drawable.marte
    ),
    Planet(
        id = 3,
        name = "Júpiter",
        type = "Gasoso",
        galaxy = "Via Láctea",
        distanceFromSun = "778.5 milhões km",
        diameter = "139,820 km",
        characteristics = "Maior planeta do sistema solar.",
        imageRes = R.drawable.jupiter
    ),
    Planet(
        id = 4,
        name = "Saturno",
        type = "Gasoso",
        galaxy = "Via Láctea",
        distanceFromSun = "1.4 bilhões km",
        diameter = "116,460 km",
        characteristics = "Possui anéis de gelo e poeira.",
        imageRes = R.drawable.saturno
    ),
    Planet(
        id = 5,
        name = "Urano",
        type = "Gasoso",
        galaxy = "Via Láctea",
        distanceFromSun = "2.8 bilhões km",
        diameter = "50,724 km",
        characteristics = "Possui anéis e eixo inclinado.",
        imageRes = R.drawable.urano
    ),
    Planet(
        id = 6,
        name = "Netuno",
        type = "Gasoso",
        galaxy = "Via Láctea",
        distanceFromSun = "4.5 bilhões km",
        diameter = "49,244 km",
        characteristics = "Possui atmosfera azul e ventos fortes.",
        imageRes = R.drawable.netuno
    ),
    Planet(
        id = 7,
        name = "Mercúrio",
        type = "Terrestre",
        galaxy = "Via Láctea",
        distanceFromSun = "57.9 milhões km",
        diameter = "4,880 km",
        characteristics = "Planeta mais próximo do Sol.",
        imageRes = R.drawable.mercurio
    ),
    Planet(
        id = 8,
        name = "Vênus",
        type = "Terrestre",
        galaxy = "Via Láctea",
        distanceFromSun = "108.2 milhões km",
        diameter = "12,104 km",
        characteristics = "Possui atmosfera densa e efeito estufa.",
        imageRes = R.drawable.venus
    ),
    Planet(
        id = 9,
        name = "Plutão",
        type = "Anão",
        galaxy = "Via Láctea",
        distanceFromSun = "5.9 bilhões km",
        diameter = "2,377 km",
        characteristics = "Planeta anão e não faz parte do sistema solar.",
        imageRes = R.drawable.plutao
    )
)