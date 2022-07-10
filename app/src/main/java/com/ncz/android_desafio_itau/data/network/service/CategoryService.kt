package com.ncz.android_desafio_itau.data.network.service

import com.ncz.android_desafio_itau.domain.model.Category
import retrofit2.http.GET

interface CategoryService {
    @GET("categorias")
    suspend fun getCategory() : List<Category>
}