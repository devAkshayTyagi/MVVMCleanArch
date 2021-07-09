package com.example.mvvmcleanarch.di

import com.example.mvvmcleanarch.view.ListingFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,UseCaseModule::class,RepositoryModule::class,MainModule::class])
interface MyComponent {

    fun inject(listingFragment: ListingFragment)

}