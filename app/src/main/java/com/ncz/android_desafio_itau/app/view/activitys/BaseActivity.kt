package com.ncz.android_desafio_itau.app.view.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ncz.android_desafio_itau.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}