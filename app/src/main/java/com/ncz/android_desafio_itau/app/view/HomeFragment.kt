package com.ncz.android_desafio_itau.app.view

import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.ncz.android_desafio_itau.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    private fun teste(){
        val image = ImageView(requireContext())
        image.setImageResource(R.drawable.ic_health_and_beauty)
    }


    companion object Categories{
        const val TRANSPORT = "Transporte"
        const val SHOPPING_ONLINE = "Compras Online"
        const val HEALTH_AND_BEAUTY = "Saúde e Beleza"
        const val AUTOMOTIVE_SERVICES = "Serviços Automotivos"
        const val RESTAURANTS= "Restaurantes"
        const val SUPERMARKET = "Super Mercados"
    }
}