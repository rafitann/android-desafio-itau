package com.ncz.android_desafio_itau.data.network.service

import com.ncz.android_desafio_itau.domain.model.Release
import com.ncz.android_desafio_itau.infrastructure.dto.ReleaseDto
import retrofit2.http.GET

interface ReleasesService {
    @GET("lancamentos")
    suspend fun getReleases(): List<ReleaseDto>
}