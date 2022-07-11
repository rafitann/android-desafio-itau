package com.ncz.android_desafio_itau.domain.repositories

import com.ncz.android_desafio_itau.domain.Entities.Release

interface InterfaceHomeRepository {
    suspend fun getReleases(): List<Release>
}