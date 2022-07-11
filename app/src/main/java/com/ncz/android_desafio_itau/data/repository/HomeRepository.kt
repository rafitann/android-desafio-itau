package com.ncz.android_desafio_itau.data.repository

import com.ncz.android_desafio_itau.domain.model.Category
import com.ncz.android_desafio_itau.infrastructure.datasources.InterfaceCategoryDataSource
import com.ncz.android_desafio_itau.infrastructure.datasources.InterfaceReleaseDataSource
import com.ncz.android_desafio_itau.domain.model.Release
import com.ncz.android_desafio_itau.domain.repositories.InterfaceHomeRepository

class HomeRepository(
    private val releaseDataSource: InterfaceReleaseDataSource,
    private val categoryDataSource: InterfaceCategoryDataSource
) : InterfaceHomeRepository {

    override suspend fun getReleases(): List<Release> {
        val categories = categoryDataSource.getCategories().map { it.mapToEntity() }

        val cats: HashMap<Int, Category> = hashMapOf()
        categories.forEach {
            cats[it.id] = it
        }

        return releaseDataSource.getRelease().map {
            val category = cats[it.id]
            it.mapToEntity().apply {
                category?.let { categoria = it }
            }
        }
    }


}


