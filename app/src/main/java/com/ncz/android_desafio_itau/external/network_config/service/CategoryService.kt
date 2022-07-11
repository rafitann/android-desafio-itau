package com.ncz.android_desafio_itau.external.network_config.service

import com.ncz.android_desafio_itau.infrastructure.dto.CategoryDto
import retrofit2.http.GET

interface CategoryService {
    @GET("categorias")
    suspend fun getCategory() : List<CategoryDto>
}