package com.ncz.android_desafio_itau.domain.Entities

import java.io.Serializable

data class Release(
    val id: Int,
    val valor: Double,
    val origem: String,
    var categoria: Category? = null,
    val mesLancamento: Int
) : Serializable