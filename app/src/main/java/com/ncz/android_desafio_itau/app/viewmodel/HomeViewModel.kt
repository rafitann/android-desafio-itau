package com.ncz.android_desafio_itau.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ncz.android_desafio_itau.external.datasources.CategoryDataSource
import com.ncz.android_desafio_itau.external.datasources.ReleaseDataSource
import com.ncz.android_desafio_itau.infrastructure.repository.HomeRepository
import com.ncz.android_desafio_itau.domain.Entities.Release
import com.ncz.android_desafio_itau.domain.repositories.InterfaceHomeRepository
import com.ncz.android_desafio_itau.domain.usescases.ReleasesUseCases
import com.ncz.android_desafio_itau.domain.utils.states.State
import com.ncz.android_desafio_itau.infrastructure.datasources.InterfaceCategoryDataSource
import com.ncz.android_desafio_itau.infrastructure.datasources.InterfaceReleaseDataSource
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception

class HomeViewModel : ViewModel() {
    private var releaseDataSource: InterfaceReleaseDataSource = ReleaseDataSource()
    var categoriesDataSource: InterfaceCategoryDataSource = CategoryDataSource()

    private var repository: InterfaceHomeRepository = HomeRepository(releaseDataSource,categoriesDataSource )
    private val usecases = ReleasesUseCases(repository)

    val releaseLiveData: MutableLiveData<State<List<Release>>> by lazy { MutableLiveData() }

    fun getReleases() {
        viewModelScope.launch {
            try {
                val release = usecases.getReleases()
                releaseLiveData.postValue(State.success(release))
            } catch (e: IOException) {
                releaseLiveData.postValue(State.networkError())
            } catch (e: Exception) {
                releaseLiveData.postValue(State.error())
            }
        }
    }

}