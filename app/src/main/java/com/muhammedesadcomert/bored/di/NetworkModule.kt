package com.muhammedesadcomert.bored.di

import com.muhammedesadcomert.bored.BuildConfig
import com.muhammedesadcomert.bored.data.api.BoredApi
import com.muhammedesadcomert.bored.data.api.InternetConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @Provides
    @ViewModelScoped
    fun provideOkHttpClient(internetConnectionInterceptor: InternetConnectionInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(internetConnectionInterceptor)
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()

    @Provides
    @ViewModelScoped
    fun provideBoredApi(okHttpClient: OkHttpClient): BoredApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BORED_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(BoredApi::class.java)
}