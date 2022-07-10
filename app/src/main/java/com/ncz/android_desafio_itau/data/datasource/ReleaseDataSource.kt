package com.ncz.android_desafio_itau.data.datasource

import com.ncz.android_desafio_itau.data.network.api.RetrofitInstance
import com.ncz.android_desafio_itau.data.network.service.ReleasesService
import com.ncz.android_desafio_itau.domain.model.Release
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class ReleaseDataSource {
 private val releaseService by lazy { RetrofitInstance.retrofit.create(ReleasesService::class.java)}

    suspend fun getReleases(): List<Release> {
        return releaseService.getReleases()
    }
}