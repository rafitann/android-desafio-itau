package com.ncz.android_desafio_itau.data.network.service

import com.ncz.android_desafio_itau.domain.model.Release
import retrofit2.http.GET

interface ReleasesService {
    @GET("lancamentos")
    suspend fun getReleases(): List<Release>
}