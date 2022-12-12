package com.muhammedesadcomert.bored.data.api

import com.muhammedesadcomert.bored.data.dto.ActivityResponse
import retrofit2.Response
import retrofit2.http.GET

interface BoredApi {

    @GET("activity")
    suspend fun getActivity(): Response<ActivityResponse>
}