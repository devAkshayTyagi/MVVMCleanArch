package com.example.mvvmcleanarch.di

import androidx.lifecycle.ViewModelProvider
import com.example.data.remote.ApiConstant
import com.example.domain.usecase.FetchTrendingRepositoryUseCase
import com.example.mvvmcleanarch.ViewModelProviderFactory
import com.example.mvvmcleanarch.view.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MainModule {

    @Provides
    fun provideMainViewModel(fetchTrendingRepositoryUseCase: FetchTrendingRepositoryUseCase): MainViewModel {
        return MainViewModel(fetchTrendingRepositoryUseCase)
    }

    @Provides
    @Named(ApiConstant.LISTING_FRAGMENT)
    fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }
}