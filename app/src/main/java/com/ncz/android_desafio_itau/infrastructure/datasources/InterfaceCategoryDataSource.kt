package com.ncz.android_desafio_itau.infrastructure.datasources

import com.ncz.android_desafio_itau.infrastructure.dto.CategoryDto

interface InterfaceCategoryDataSource {
    suspend fun getCategories(): List<CategoryDto>
}