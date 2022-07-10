package com.ncz.android_desafio_itau.domain.usescases

import com.ncz.android_desafio_itau.data.network.service.InterfaceCategoryRepository
import com.ncz.android_desafio_itau.data.repository.ReleaseRepository

class CategoryUseCases(
    private val repository: InterfaceCategoryRepository
) {
    suspend fun getCategory() = repository.getCategory()
}