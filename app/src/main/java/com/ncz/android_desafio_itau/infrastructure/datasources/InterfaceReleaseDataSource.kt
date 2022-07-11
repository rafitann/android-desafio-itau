package com.ncz.android_desafio_itau.infrastructure.datasources

import com.ncz.android_desafio_itau.infrastructure.dto.ReleaseDto

interface InterfaceReleaseDataSource {

    suspend fun getRelease(): List<ReleaseDto>
}