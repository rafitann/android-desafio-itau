package com.ncz.android_desafio_itau.data.datasource

import com.ncz.android_desafio_itau.data.network.api.RetrofitInstance
import com.ncz.android_desafio_itau.data.network.service.CategoryService
import com.ncz.android_desafio_itau.data.network.service.ReleasesService
import com.ncz.android_desafio_itau.domain.model.Category

class CategoryDataSource {
    private val categoryService by lazy { RetrofitInstance.retrofit.create(CategoryService::class.java)}

    suspend fun getCategory(): List<Category> {
        return categoryService.getCategory()
    }
}