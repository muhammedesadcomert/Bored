package com.muhammedesadcomert.bored.data.network

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import java.net.InetAddress
import javax.inject.Inject

class InternetConnectionInterceptor @Inject constructor(@ApplicationContext private val context: Context) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return if (!hasInternetConnection()) {
            throw NoInternetException(context)
        } else {
            chain.proceed(chain.request().newBuilder().build())
        }
    }

    private fun hasInternetConnection(): Boolean {
        return try {
            InetAddress.getByName("google.com").equals("").not()
        } catch (e: Exception) {
            false
        }
    }
}