package com.ncz.android_desafio_itau.domain.usecases

import com.ncz.android_desafio_itau.domain.repositories.InterfaceHomeRepository
import com.ncz.android_desafio_itau.domain.usescases.ReleasesUseCases
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

class HomeUseCasesTest {
    private val repository: InterfaceHomeRepository = Mockito.mock(InterfaceHomeRepository::class.java)
    private val useCases: ReleasesUseCases = ReleasesUseCases(repository = repository)

    @Before
    fun init() {}

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should fetch the API releases`() {
        runTest {
            val testDispatcher = UnconfinedTestDispatcher(this.testScheduler)
            with(Dispatchers) {
                setMain(testDispatcher)
            }

            Mockito.`when`(repository.getReleases()).thenReturn(getReleasesEntityResponseMock())

            Assert.assertNotNull(useCases.getReleases())

            Mockito.verify(repository, Mockito.times(1)).getReleases()

        }
    }
}