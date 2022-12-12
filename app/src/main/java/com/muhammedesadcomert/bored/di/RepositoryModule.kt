package com.muhammedesadcomert.bored.di

import com.muhammedesadcomert.bored.data.repository.BoredRepository
import com.muhammedesadcomert.bored.data.repository.BoredRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindBoredRepository(boredRepositoryImpl: BoredRepositoryImpl): BoredRepository
}