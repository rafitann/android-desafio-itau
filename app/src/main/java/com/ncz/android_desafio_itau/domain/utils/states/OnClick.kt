package com.ncz.android_desafio_itau.domain.utils.states

import com.ncz.android_desafio_itau.domain.model.Release

interface OnClick {
    fun onCellClickListener(release: Release)
}