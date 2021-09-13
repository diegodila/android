package br.com.fiap.app16.models

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name: String,
    @SerializedName("sprites") val images: Sprites
)

data class Sprites (
    @SerializedName ("front_default") val front: String
)