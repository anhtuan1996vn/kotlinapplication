package com.testing.kotlinapplication.ui.authencation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.testing.kotlinapplication.R

class AuthencationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authencation)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}