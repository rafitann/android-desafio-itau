package com.ncz.android_desafio_itau.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Release(
    val id: Int,
    val valor: Double,
    val origem: String,
    var categoria: Category? = null,
    val mesLancamento: Int
) : Serializable