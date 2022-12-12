package com.muhammedesadcomert.bored.di

import com.muhammedesadcomert.bored.di.coroutine.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object CoroutineDispatchersModule {

    @IoDispatcher
    @Provides
    @ViewModelScoped
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}