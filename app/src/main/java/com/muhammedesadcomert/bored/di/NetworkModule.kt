package com.muhammedesadcomert.bored.di

import com.muhammedesadcomert.bored.BuildConfig
import com.muhammedesadcomert.bored.data.network.BoredApi
import com.muhammedesadcomert.bored.data.network.InternetConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(internetConnectionInterceptor: InternetConnectionInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(internetConnectionInterceptor)
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()

    @Provides
    @Singleton
    fun provideBoredApi(okHttpClient: OkHttpClient): BoredApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BORED_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(BoredApi::class.java)
}