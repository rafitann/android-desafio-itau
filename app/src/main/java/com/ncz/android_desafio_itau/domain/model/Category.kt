package com.ncz.android_desafio_itau.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(
    @SerializedName("id") val id: Int,
    @SerializedName("nome") val nome: String
):Serializable