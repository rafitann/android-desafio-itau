package com.ncz.android_desafio_itau.domain.utils.states

import java.text.NumberFormat

fun Double.toCurrencyFormat(): String {
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.maximumFractionDigits = 2;
    return numberFormat.format(this)
}