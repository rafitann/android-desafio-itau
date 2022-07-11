package com.ncz.android_desafio_itau.mockers

import com.ncz.android_desafio_itau.domain.entities.Category
import com.ncz.android_desafio_itau.domain.entities.Release
import com.ncz.android_desafio_itau.infrastructure.dto.ReleaseDto


fun getReleasesEntityResponseMock(): List<Release> {
    return listOf(
        Release(
            id = 1,
            valor = 1.0,
            origem = "",
            categoria = Category(1, ""),
            mesLancamento = 1
        ), Release(
            id = 2,
            valor = 2.0,
            origem = "",
            categoria = Category(2, ""),
            mesLancamento = 2
        ),
    )
}

fun getReleasesDtoResponseMock(): List<ReleaseDto> {
    return listOf(
        ReleaseDto(
            id = 1,
            valor = 1.0,
            origem = "",
            categoria = 1,
            mesLancamento = 1
        ), ReleaseDto(
            id = 2,
            valor = 2.0,
            origem = "",
            categoria = 2,
            mesLancamento = 2
        ),
    )
}

fun getReleasesApiResponseMock(): String {
    return """[
  {
    "id": 1,
    "valor": 13.3,
    "origem": "Uber",
    "categoria": 1,
    "mes_lancamento": 1
  },
  {
    "id": 2,
    "valor": 130.5,
    "origem": "PS Store",
    "categoria": 2,
    "mes_lancamento": 2
  },
  {
    "id": 3,
    "valor": 1023.66,
    "origem": "Carrefour",
    "categoria": 6,
    "mes_lancamento": 5
  },
  {
    "id": 4,
    "valor": 132.44,
    "origem": "Mercado Três Irmãos",
    "categoria": 6,
    "mes_lancamento": 6
  },
  {
    "id": 5,
    "valor": 65.3,
    "origem": "Drogasil",
    "categoria": 3,
    "mes_lancamento": 7
  }
]"""
}