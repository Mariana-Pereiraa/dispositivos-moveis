package com.example.playersspfc.models
import com.example.playersspfc.R

data class Players (
    val id: Int,
    val name: String,
    val position: String,
    val imageRes: Int,
    val description: String,
    val curiosities: String,
    var isFavorite: Boolean = false
)

val playersList = listOf(
    Players(
        id = 1,
        name = "Jonathan Calleri",
        position = "Atacante",
        imageRes = R.drawable.calleri,
        description = "Argentino, 31 anos",
        curiosities = "Único time brasileiro que jogo é o SP"
    ),

    Players(
        id = 2,
        name = "Lucas Moura",
        position = "Meia",
        imageRes = R.drawable.lucas,
        description = "Brasileiro, 32 anos",
        curiosities = "Sou pai do curintia"
    ),

    Players(
        id = 3,
        name = "Rafinha",
        position = "Lateral",
        imageRes = R.drawable.rafinha,
        description = "Brasileiro, 38 anos",
        curiosities = "Coleciono camisas de futebol desde os 15 anos"
    ),
    Players(
        id = 4,
        name = "Alisson",
        position = "Meia",
        imageRes = R.drawable.alisson,
        description = "Brasileiro, 30 anos",
        curiosities = "Tenho uma paixão por carros antigos"
    ),
    Players(
        id = 5,
        name = "Arboleda",
        position = "Zagueiro",
        imageRes = R.drawable.arboleda,
        description = "Equatoriano, 32 anos",
        curiosities = "Mais conhecido como Arbolenda"
    ),
    Players(
        id = 6,
        name = "Luciano",
        position = "Atacante",
        imageRes = R.drawable.luciano,
        description = "Brasileiro, 30 anos",
        curiosities = "Gosto de provocar os rivais"
    ),
    Players(
        id = 7,
        name = "Pablo Maia",
        position = "Volante",
        imageRes = R.drawable.pablo_maia,
        description = "Brasileiro, 21 anos",
        curiosities = "Sempre leio quadrinhos da Marvel no meu tempo livre"
    ),
    Players(
        id = 8,
        name = "Rodrigo Nestor",
        position = "Meia",
        imageRes = R.drawable.nestor,
        description = "Brasileiro, 23 anos",
        curiosities = "Sou muito chorão"
    ),
    Players(
        id = 9,
        name = "Wellington Rato",
        position = "Meia",
        imageRes = R.drawable.rato,
        description = "Brasileiro, 31 anos",
        curiosities = "Gosto de puxar pra esquerda..."
    ),

    Players(
        id = 10,
        name = "Jandrei",
        position = "Goleiro",
        imageRes = R.drawable.jandrei,
        description = "Brasileiro, 30 anos",
        curiosities = "Às vezes tenho a mão de alface"
    ),

    Players(
        id = 12,
        name = "Alan Franco",
        position = "Zagueiro",
        imageRes = R.drawable.alan,
        description = "Equatoriano, 24 anos",
        curiosities = "Gosto de colocar os rivais no bolso"
    ),

    Players(
        id = 13,
        name = "Michel Araújo",
        position = "Meia",
        imageRes = R.drawable.michel,
        description = "Uruguaio, 27 anos",
        curiosities = "Sempre assisto filmes de ficção científica"
    ),

    Players(
        id = 14,
        name = "Jamal Lewis",
        position = "Zagueiro",
        imageRes = R.drawable.jamal,
        description = "Britânico, 26 anos",
        curiosities = "Pratico meditação todos os dias pela manhã"
    ),

    Players(
        id = 15,
        name = "William Gomes",
        position = "Brasileiro",
        imageRes = R.drawable.william,
        description = "Brasileiro, 18 anos",
        curiosities = "Tenho uma coleção de jogos de videogame retrô"
    ),

    Players(
        id = 16,
        name = "Damián Bobadilla",
        position = "Meia",
        imageRes = R.drawable.bobadilla,
        description = "Paraguaio, 23 anos",
        curiosities = "Toco violão desde os 10 anos de idade"
    ),

    Players(
        id = 17,
        name = "Moreira",
        position = "Zagueiro",
        imageRes = R.drawable.moreira,
        description = "Brasileiro, 20 anos",
        curiosities = "Gosto de jogos de tabuleiro estratégicos"
    ),

    Players(
        id = 18,
        name = "Erick",
        position = "Atacante",
        imageRes = R.drawable.erick,
        description = "Brasileiro, 26 anos",
        curiosities = "Amo praticar tênis de mesa"
    ),

    Players(
        id = 19,
        name = "Wellington",
        position = "Lateral",
        imageRes = R.drawable.wellington,
        description = "Brasileiro, 23 anos",
        curiosities = "Meu passatempo favorito é desenhar caricaturas"
    ),

    Players(
        id = 20,
        name = "Ferreirinha",
        position = "Atacante",
        imageRes = R.drawable.ferreira,
        description = "Brasileiro, 26 anos",
        curiosities = "Sou apaixonado por jardinagem e cultivo flores"
    ),

    Players(
        id = 21,
        name = "Rafael",
        position = "Goleiro",
        imageRes = R.drawable.rafael,
        description = "Brasileiro, 30 anos",
        curiosities = "Sou o melhor"
    )
)