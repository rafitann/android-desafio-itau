package com.ncz.android_desafio_itau.infrastructure.dto

import com.google.gson.annotations.SerializedName
import com.ncz.android_desafio_itau.domain.model.Category
import java.io.Serializable

data class CategoryDto (
    @SerializedName("id") val id: Int,
    @SerializedName("nome") val nome: String
): Serializable {

    fun mapToEntity(): Category = Category(
        id = this.id,
        nome = this.nome
    )
}