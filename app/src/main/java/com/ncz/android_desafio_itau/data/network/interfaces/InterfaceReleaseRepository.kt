package com.ncz.android_desafio_itau.data.network.interfaces

import com.ncz.android_desafio_itau.domain.model.Release

interface InterfaceReleaseRepository {
    suspend fun getRelease(): List<Release>
}