package com.example.mvvmcleanarch.di

import com.example.data.remote.ApiClient
import com.example.data.remote.ApiServices
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApiServices(): ApiServices {
        return ApiClient.getClient()!!.create(ApiServices::class.java)
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
