package com.ncz.android_desafio_itau.data.repository

import com.ncz.android_desafio_itau.data.datasource.ReleaseDataSource
import com.ncz.android_desafio_itau.data.network.service.InterfaceReleaseRepository
import com.ncz.android_desafio_itau.domain.model.Release
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ReleaseRepository(
    private val dataSource: ReleaseDataSource
) : InterfaceReleaseRepository {

    override suspend fun getRelease(): List<Release> = withContext(Dispatchers.IO){
        dataSource.getReleases()
    }
}


