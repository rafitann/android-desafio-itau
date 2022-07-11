package com.ncz.android_desafio_itau.infrastructure.repositories

import com.ncz.android_desafio_itau.domain.repositories.InterfaceHomeRepository
import com.ncz.android_desafio_itau.infrastructure.datasources.InterfaceCategoryDataSource
import com.ncz.android_desafio_itau.infrastructure.datasources.InterfaceReleaseDataSource
import com.ncz.android_desafio_itau.infrastructure.repository.HomeRepository
import com.ncz.android_desafio_itau.mockers.getCategoriesDtoResponseMock
import com.ncz.android_desafio_itau.mockers.getReleasesDtoResponseMock
import com.ncz.android_desafio_itau.mockers.getReleasesEntityResponseMock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class HomeRepositoryTest {

    private val releaseDataSource: InterfaceReleaseDataSource =
        Mockito.mock(InterfaceReleaseDataSource::class.java)
    private val categoryDataSource: InterfaceCategoryDataSource =
        Mockito.mock(InterfaceCategoryDataSource::class.java)

    private val repository: InterfaceHomeRepository = HomeRepository(
        releaseDataSource = releaseDataSource,
        categoryDataSource = categoryDataSource
    )

    @Before
    fun init() {
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should fetch the API releases`() {
        runTest {
            val testDispatcher = UnconfinedTestDispatcher(this.testScheduler)
            Dispatchers.setMain(testDispatcher)

            val releasesDtoResponseMock = getReleasesDtoResponseMock()
            val categoriesDtoResponseMock = getCategoriesDtoResponseMock()
            Mockito.`when`(releaseDataSource.getRelease()).thenReturn(releasesDtoResponseMock)
            Mockito.`when`(categoryDataSource.getCategories()).thenReturn(categoriesDtoResponseMock)

            val releases = repository.getReleases()
            val releasesEntityResponseMock = getReleasesEntityResponseMock()

            Mockito.verify(releaseDataSource, Mockito.times(1)).getRelease()
            Mockito.verify(categoryDataSource, Mockito.times(1)).getCategories()

            Assert.assertNotNull(releases)
            Assert.assertEquals(releasesEntityResponseMock, releases)
        }
    }


}
