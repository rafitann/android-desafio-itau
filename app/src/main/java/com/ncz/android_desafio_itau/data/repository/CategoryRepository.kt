package com.ncz.android_desafio_itau.data.repository

import com.ncz.android_desafio_itau.data.datasource.CategoryDataSource
import com.ncz.android_desafio_itau.data.network.service.InterfaceCategoryRepository
import com.ncz.android_desafio_itau.domain.model.Category

class CategoryRepository(
    private val dataSource: CategoryDataSource
) : InterfaceCategoryRepository {

    override suspend fun getCategory(): List<Category> = dataSource.getCategory()
}