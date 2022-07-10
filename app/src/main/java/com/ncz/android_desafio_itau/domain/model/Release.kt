package com.ncz.android_desafio_itau.domain.model

import com.google.gson.annotations.SerializedName

data class Release(
    @SerializedName("id") val id: Int,
    @SerializedName("valor") val valor: Double,
    @SerializedName("origem") val origem: String,
    @SerializedName("categoria") val categoria: Int,
    @SerializedName("mes_lancamento") val mesLancamento: Int
)