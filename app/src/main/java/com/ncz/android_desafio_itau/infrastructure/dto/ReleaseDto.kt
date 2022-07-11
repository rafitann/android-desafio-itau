package com.ncz.android_desafio_itau.infrastructure.dto

import com.google.gson.annotations.SerializedName
import com.ncz.android_desafio_itau.domain.model.Release
import java.io.Serializable

data class ReleaseDto(
    @SerializedName("id") val id: Int,
    @SerializedName("valor") val valor: Double,
    @SerializedName("origem") val origem: String,
    @SerializedName("categoria") val categoria: Int,
    @SerializedName("mes_lancamento") val mesLancamento: Int
): Serializable {

    fun mapToEntity(): Release = Release(
        id = this.id,
        valor = this.valor,
        origem = this.origem,
        mesLancamento = this.mesLancamento,
    )

}