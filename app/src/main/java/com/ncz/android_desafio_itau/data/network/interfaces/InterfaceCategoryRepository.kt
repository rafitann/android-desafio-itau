package com.ncz.android_desafio_itau.data.network.interfaces

import com.ncz.android_desafio_itau.domain.model.Category

interface InterfaceCategoryRepository {
    suspend fun getCategory(): List<Category>
}