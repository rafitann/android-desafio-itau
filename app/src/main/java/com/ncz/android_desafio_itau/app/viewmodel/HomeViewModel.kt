package com.ncz.android_desafio_itau.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ncz.android_desafio_itau.data.datasource.ReleaseDataSource
import com.ncz.android_desafio_itau.data.repository.ReleaseRepository
import com.ncz.android_desafio_itau.domain.model.Release
import com.ncz.android_desafio_itau.domain.usescases.ReleasesUseCases
import com.ncz.android_desafio_itau.domain.utils.states.State
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception

class HomeViewModel : ViewModel() {
    private val dataSource = ReleaseDataSource()
    private val repository = ReleaseRepository(dataSource)
    private val usecases = ReleasesUseCases(repository)


    private val releaseLiveData: MutableLiveData<State<List<Release>>> by lazy { MutableLiveData() }

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