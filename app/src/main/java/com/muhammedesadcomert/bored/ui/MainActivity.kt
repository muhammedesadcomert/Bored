package com.muhammedesadcomert.bored.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.muhammedesadcomert.bored.ui.home.Home
import com.muhammedesadcomert.bored.ui.theme.BoredTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoredTheme {
                Home()
            }
        }
    }
}