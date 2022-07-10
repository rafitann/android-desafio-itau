package com.ncz.android_desafio_itau.domain.usescases

import com.ncz.android_desafio_itau.data.network.service.InterfaceReleaseRepository
import com.ncz.android_desafio_itau.data.repository.ReleaseRepository

class ReleasesUseCases(
    private val repository: InterfaceReleaseRepository
) {
    suspend fun getReleases() = repository.getRelease()
}