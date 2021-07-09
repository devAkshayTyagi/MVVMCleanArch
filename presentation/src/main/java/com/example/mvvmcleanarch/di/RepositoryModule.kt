package com.example.mvvmcleanarch.di

import com.example.data.remote.ApiServices
import com.example.data.repository.MainRepositoryImpl
import com.example.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        apiServices: ApiServices
    ): MainRepository {
        return MainRepositoryImpl(apiServices)
    }
}