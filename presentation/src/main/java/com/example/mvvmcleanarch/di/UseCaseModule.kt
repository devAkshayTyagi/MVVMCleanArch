package com.example.mvvmcleanarch.di

import com.example.domain.repository.MainRepository
import com.example.domain.usecase.FetchTrendingRepositoryUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class UseCaseModule {

    @Provides
    fun provideGetTrendingRepositoryUseCase(
        postExecutionThread: Scheduler,
        mainRepository: MainRepository
    ): FetchTrendingRepositoryUseCase {
        return FetchTrendingRepositoryUseCase(mainRepository, postExecutionThread)
    }
}