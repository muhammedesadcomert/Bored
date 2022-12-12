package com.muhammedesadcomert.bored.data.api

import android.content.Context
import com.muhammedesadcomert.bored.R
import java.io.IOException
import javax.inject.Inject

class NoInternetException @Inject constructor(private val context: Context) : IOException() {
    override val message: String
        get() = context.getString(R.string.no_internet_error)
}