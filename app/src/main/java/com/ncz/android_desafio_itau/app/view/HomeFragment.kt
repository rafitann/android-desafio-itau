package com.ncz.android_desafio_itau.app.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ncz.android_desafio_itau.R
import com.ncz.android_desafio_itau.app.view.adapters.HomeAdapter
import com.ncz.android_desafio_itau.app.viewmodel.HomeViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    val HomeViewModel: HomeViewModel by viewModels()
    private val adapter = HomeAdapter()

    companion object Categories{
        const val TRANSPORT = "Transporte"
        const val SHOPPING_ONLINE = "Compras Online"
        const val HEALTH_AND_BEAUTY = "Saúde e Beleza"
        const val AUTOMOTIVE_SERVICES = "Serviços Automotivos"
        const val RESTAURANTS= "Restaurantes"
        const val SUPERMARKET = "Super Mercados"
    }
}