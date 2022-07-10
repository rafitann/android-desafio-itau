package com.ncz.android_desafio_itau.domain.usescases

import com.ncz.android_desafio_itau.data.network.interfaces.InterfaceCategoryRepository

class CategoryUseCases(
    private val repository: InterfaceCategoryRepository
) {
    suspend fun getCategory() = repository.getCategory()
}