package com.muhammedesadcomert.bored.data.repository

import com.muhammedesadcomert.bored.data.dto.ActivityResponse
import com.muhammedesadcomert.bored.util.NetworkResponseState

interface BoredRepository {
    suspend fun getActivity(): NetworkResponseState<ActivityResponse>
}