package com.muhammedesadcomert.bored.di

import com.muhammedesadcomert.bored.data.dto.ActivityResponse
import com.muhammedesadcomert.bored.domain.entity.ActivityEntity
import com.muhammedesadcomert.bored.domain.mapper.BoredActivityMapper
import com.muhammedesadcomert.bored.domain.mapper.DomainMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindBoredActivityMapper(boredActivityMapper: BoredActivityMapper): DomainMapper<ActivityResponse, ActivityEntity>
}