package br.com.fiap.nacandroid.models

import com.google.gson.annotations.SerializedName

data class Covid (
    val name: String,
    @SerializedName("uf") val UF: String,
    @SerializedName("state") val estado: String,
    @SerializedName("cases") val casos: String,
    @SerializedName("deaths") val mortes: String,
    @SerializedName("datetime") val data: String
)