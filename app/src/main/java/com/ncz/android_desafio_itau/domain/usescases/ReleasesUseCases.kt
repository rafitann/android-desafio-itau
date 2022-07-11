package com.ncz.android_desafio_itau.domain.usescases

import com.ncz.android_desafio_itau.domain.repositories.InterfaceHomeRepository

class ReleasesUseCases(
    private val repository: InterfaceHomeRepository
) {
    suspend fun getReleases() = repository.getReleases()
}