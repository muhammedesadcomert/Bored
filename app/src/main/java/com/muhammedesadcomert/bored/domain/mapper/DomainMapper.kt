package com.muhammedesadcomert.bored.domain.mapper

interface DomainMapper<Dto, DomainModel> {
    fun mapToDomainModel(data: Dto): DomainModel
}
