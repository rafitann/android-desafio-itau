package com.ncz.android_desafio_itau.external.datasources

import com.ncz.android_desafio_itau.external.network_config.api.RetrofitInstance
import com.ncz.android_desafio_itau.external.network_config.service.CategoryService
import com.ncz.android_desafio_itau.infrastructure.datasources.InterfaceCategoryDataSource
import com.ncz.android_desafio_itau.infrastructure.dto.CategoryDto

open class CategoryDataSource : InterfaceCategoryDataSource {
    private val categoryService by lazy { RetrofitInstance.retrofit.create(CategoryService::class.java) }

    override suspend fun getCategories(): List<CategoryDto> {
        return categoryService.getCategory()
    }
}