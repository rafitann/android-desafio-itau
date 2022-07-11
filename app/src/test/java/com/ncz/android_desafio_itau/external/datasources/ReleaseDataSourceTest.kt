package com.ncz.android_desafio_itau.external.datasources

import com.ncz.android_desafio_itau.external.network_config.api.RetrofitInstance
import com.ncz.android_desafio_itau.infrastructure.datasources.InterfaceReleaseDataSource
import com.ncz.android_desafio_itau.mockers.getReleasesApiResponseMock
import com.ncz.android_desafio_itau.mockers.getReleasesDtoResponseMock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReleaseDataSourceTest {

    private val datasource: InterfaceReleaseDataSource = ReleaseDataSource()

    @Before
    fun init() {
    }

//    @Test
//    fun `should fetch the API releases`() {
//        runTest {
//            val testDispatcher = UnconfinedTestDispatcher(testScheduler)
//            Dispatchers.setMain(testDispatcher)
//
//            Assert.assertNotNull(testDispatcher)
//
//            val server = MockWebServer()
//            server.start()
//            server.enqueue(MockResponse().setResponseCode(200).setBody(getReleasesApiResponseMock()))
//
//            val retrofit = Retrofit.Builder()
//                .baseUrl(server.url(""))
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            val instance = Mockito.mock(RetrofitInstance::class.java)
//            Mockito.`when`(instance.retrofit).thenReturn(retrofit)
//
//            val datasource = Mockito.mock(ReleaseDataSource::class.java)
//            Mockito.`when`(datasource.releaseService).thenReturn(retrofit)
//
//            val releases = datasource.getRelease()
//            val releaseDtoResponse = getReleasesDtoResponseMock()
//
//            Assert.assertNotNull(releases)
//            Assert.assertEquals(releaseDtoResponse, releases)
//
//            server.shutdown()
//        }
//    }


}
