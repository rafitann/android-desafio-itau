package com.ncz.android_desafio_itau.domain.utils.extensions

import com.ncz.android_desafio_itau.domain.entities.Release

interface OnClick {
    fun onCellClickListener(release: Release)
}