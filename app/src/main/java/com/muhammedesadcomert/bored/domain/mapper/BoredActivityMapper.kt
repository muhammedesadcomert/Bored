package com.muhammedesadcomert.bored.domain.mapper

import com.muhammedesadcomert.bored.data.dto.ActivityResponse
import com.muhammedesadcomert.bored.domain.entity.ActivityEntity
import javax.inject.Inject

class BoredActivityMapper @Inject constructor() : DomainMapper<ActivityResponse, ActivityEntity> {

    override fun mapToDomainModel(data: ActivityResponse) = ActivityEntity(
        activity = data.activity,
        type = data.type,
        link = data.link
    )
}