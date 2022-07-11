package com.ncz.android_desafio_itau.mockers

import com.ncz.android_desafio_itau.infrastructure.dto.CategoryDto

fun getCategoriesDtoResponseMock(): List<CategoryDto> {
    return listOf(
        CategoryDto(
            id = 1,
            nome = ""
        ), CategoryDto(
            id = 2,
            nome = ""
        ),
    )
}