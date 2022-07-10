package com.ncz.android_desafio_itau.domain.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id") val id: Int,
    @SerializedName("nome") val nome: String
)