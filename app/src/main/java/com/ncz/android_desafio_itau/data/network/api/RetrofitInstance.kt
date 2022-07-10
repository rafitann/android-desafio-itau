package com.ncz.android_desafio_itau.data.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://desafio-it-server.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}