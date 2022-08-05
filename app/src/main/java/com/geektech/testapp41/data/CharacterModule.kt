package com.geektech.testapp41.data

import com.geektech.testapp41.data.common.module.NetworkModule
import com.geektech.testapp41.data.remote.CharacterApi
import com.geektech.testapp41.data.repository.CharacterRepositoryImpl
import com.geektech.testapp41.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class CharacterModule {
    @Singleton
    @Provides
    fun provideMainApi(retrofit: Retrofit): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMainRepository(api: CharacterApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }
}