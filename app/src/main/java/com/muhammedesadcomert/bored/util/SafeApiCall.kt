package com.muhammedesadcomert.bored.util

import com.muhammedesadcomert.bored.data.network.NoInternetException
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object SafeApiCall {
    inline fun <T> safeApiCall(block: () -> Response<T>): NetworkResponseState<T> {
        return try {
            val response = block()
            if (response.isSuccessful) {
                NetworkResponseState.Success(response.body()!!)
            } else {
                NetworkResponseState.Error(response.message())
            }
        } catch (e: IOException) {
            NetworkResponseState.Error(e.message.orEmpty())
        } catch (e: HttpException) {
            NetworkResponseState.Error(e.message.orEmpty())
        } catch (e: Exception) {
            NetworkResponseState.Error(e.message.orEmpty())
        } catch (e: NoInternetException) {
            NetworkResponseState.Error(e.message)
        }
    }
}