package com.david.fructus.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.david.fructus.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FructusMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fructus_main)
    }
}