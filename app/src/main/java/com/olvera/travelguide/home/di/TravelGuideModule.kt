package com.olvera.travelguide.home.di

import com.olvera.travelguide.home.data.HomeRepositoryImpl
import com.olvera.travelguide.home.data.remote.ApiKeyInterceptor
import com.olvera.travelguide.home.data.remote.ChatgptApi
import com.olvera.travelguide.home.domain.HomeRepository
import com.olvera.travelguide.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object TravelGuideModule {

    @Provides
    @Singleton
    fun provideApi(): ChatgptApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor())
                    .addInterceptor(ApiKeyInterceptor()).build()
            ).build()
            .create()
    }

    @Provides
    @Singleton
    fun provideRepository(api: ChatgptApi): HomeRepository {
        return HomeRepositoryImpl(api)
    }

}