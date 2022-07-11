package com.ncz.android_desafio_itau.external.datasources

import com.ncz.android_desafio_itau.external.network_config.api.RetrofitInstance
import com.ncz.android_desafio_itau.external.network_config.service.ReleasesService
import com.ncz.android_desafio_itau.infrastructure.datasources.InterfaceReleaseDataSource
import com.ncz.android_desafio_itau.infrastructure.dto.ReleaseDto

open class ReleaseDataSource : InterfaceReleaseDataSource {

    private val releaseService by lazy { RetrofitInstance.retrofit.create(ReleasesService::class.java) }

    override suspend fun getRelease(): List<ReleaseDto> {
        return releaseService.getReleases()
    }
}