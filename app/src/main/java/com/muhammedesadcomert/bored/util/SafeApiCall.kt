package com.muhammedesadcomert.bored.util

import retrofit2.Response

object SafeApiCall {
    inline fun <T> safeApiCall(block: () -> Response<T>): NetworkResponseState<T> {
        return try {
            val response = block()
            if (response.isSuccessful) {
                NetworkResponseState.Success(response.body()!!)
            } else {
                NetworkResponseState.Error(response.message())
            }
        } catch (e: Exception) {
            NetworkResponseState.Error(e.message.orEmpty())
        }
    }
}