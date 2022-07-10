package com.ncz.android_desafio_itau.domain.usescases

import com.ncz.android_desafio_itau.data.network.interfaces.InterfaceReleaseRepository

class ReleasesUseCases(
    private val repository: InterfaceReleaseRepository
) {
    suspend fun getReleases() = repository.getRelease()
}