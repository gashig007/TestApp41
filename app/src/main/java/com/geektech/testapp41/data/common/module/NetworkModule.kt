package com.geektech.testapp41.data.common.module

import com.geektech.testapp41.BuildConfig
import com.geektech.testapp41.data.remote.CharacterApi
import com.geektech.testapp41.data.repository.CharacterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
        }.build()
    }

    @Singleton
    @Provides
    fun provideOkHttp() : OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
        }.build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): CharacterApi = retrofit.create(CharacterApi::class.java)

    @Singleton
    @Provides
    fun provideRepository(api: CharacterApi): CharacterRepositoryImpl =
        CharacterRepositoryImpl(api)
}