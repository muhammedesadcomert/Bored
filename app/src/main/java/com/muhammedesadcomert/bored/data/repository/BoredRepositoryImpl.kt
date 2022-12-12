package com.muhammedesadcomert.bored.data.repository

import com.muhammedesadcomert.bored.data.api.BoredApi
import com.muhammedesadcomert.bored.data.dto.ActivityResponse
import com.muhammedesadcomert.bored.di.coroutine.IoDispatcher
import com.muhammedesadcomert.bored.util.NetworkResponseState
import com.muhammedesadcomert.bored.util.SafeApiCall.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BoredRepositoryImpl @Inject constructor(
    private val boredApi: BoredApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BoredRepository {
    override suspend fun getActivity(): NetworkResponseState<ActivityResponse> =
        withContext(ioDispatcher) {
            safeApiCall { boredApi.getActivity() }
        }
}
